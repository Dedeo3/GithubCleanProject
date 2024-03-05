package com.dicoding.core.domain.use_case

import com.dicoding.core.data.Resource
import com.dicoding.core.domain.interface_repository.InterfaceUserRepository
import com.dicoding.core.domain.model.User
import kotlinx.coroutines.flow.Flow

class UseCaseInteractor(private val repository: InterfaceUserRepository): UserUseCase() {

    override fun getAllUser(): Flow<Resource<List<User>>> {
        return repository.getUser()
    }

    override fun getFavorite() = repository.getFavorite()

    override fun setFavorite(user: User, state: Boolean) = repository.setFavorite(user, state)
}