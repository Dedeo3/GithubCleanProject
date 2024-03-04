package com.dicoding.core.domain.interface_repository


import com.dicoding.core.data.Resource
import com.dicoding.core.domain.model.User
import kotlinx.coroutines.flow.Flow

interface InterfaceUserRepository {
    fun getUser(): Flow<Resource<List<User>>>

//    fun getFavoriteTourism(): Flow<List<Tourism>>
//
//    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}