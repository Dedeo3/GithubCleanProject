package com.dicoding.core.data

import com.dicoding.core.data.local.LocalDataSource
import com.dicoding.core.data.remote.RemoteDataSource
import com.dicoding.core.data.remote.response.ApiResponse
import com.dicoding.core.data.remote.response.DetailUserResponse
import com.dicoding.core.data.remote.response.ItemsItem
import com.dicoding.core.domain.interface_repository.InterfaceUserRepository
import com.dicoding.core.domain.model.User
import com.dicoding.core.utils.AppExecutors
import com.dicoding.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : InterfaceUserRepository {

    override fun getUser(): Flow<Resource<List<User>>> =
        object : NetworkBoundResource<List<User>, List<ItemsItem>>() {
            override fun loadFromDB(): Flow<List<User>> {
                return localDataSource.getAllUser().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<User>?): Boolean =
//                data == null || data.isEmpty()
                true // ganti dengan true jika ingin selalu mengambil data dari internet

            override suspend fun createCall(): Flow<ApiResponse<List<ItemsItem>>> =
                remoteDataSource.getAllUser()

            override suspend fun saveCallResult(data: List<ItemsItem>) {
                val userList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertUser(userList)
            }
        }.asFlow()


    override fun getFavorite(): Flow<List<User>> {
        return localDataSource.getFavoriteTourism().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavorite(user: User, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(user)
        appExecutors.diskIO().execute { localDataSource.setFavorite(tourismEntity, state) }
    }
}