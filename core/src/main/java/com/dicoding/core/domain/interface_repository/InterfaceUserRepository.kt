package com.dicoding.core.domain.interface_repository


import com.dicoding.core.data.Resource
import com.dicoding.core.data.remote.response.ApiResponse
import com.dicoding.core.data.remote.response.DetailUserResponse
import com.dicoding.core.domain.model.User
import kotlinx.coroutines.flow.Flow

interface InterfaceUserRepository {
    fun getUser(): Flow<Resource<List<User>>>



    fun getFavorite(): Flow<List<User>>

    fun setFavorite(user: User, state: Boolean)
}