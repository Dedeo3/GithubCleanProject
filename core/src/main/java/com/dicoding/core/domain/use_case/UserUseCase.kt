package com.dicoding.core.domain.use_case

import com.dicoding.core.data.Resource
import com.dicoding.core.domain.model.User
import kotlinx.coroutines.flow.Flow

abstract class UserUseCase {
    abstract fun getAllUser(): Flow<Resource<List<User>>>
    abstract fun getFavorite(): Flow<List<User>>
    abstract fun setFavorite(user:User, state: Boolean)
}