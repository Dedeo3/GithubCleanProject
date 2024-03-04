package com.dicoding.core.domain.use_case

import com.dicoding.core.data.Resource
import com.dicoding.core.domain.model.User
import kotlinx.coroutines.flow.Flow

abstract class UserUseCase {
    abstract fun getAllUser(): Flow<Resource<List<User>>>
//    fun getFavoriteTourism(): Flow<List<Tourism>>
//    fun setFavoriteTourism(tourism: Tourism, state: Boolean)
}