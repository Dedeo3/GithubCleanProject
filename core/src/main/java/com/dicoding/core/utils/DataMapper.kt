package com.dicoding.core.utils

import com.dicoding.core.data.local.entity.UserEntity
import com.dicoding.core.data.remote.response.ItemsItem
import com.dicoding.core.data.remote.response.UserResponse
import com.dicoding.core.domain.model.User

object DataMapper {
    fun mapResponsesToEntities(
        input: List<ItemsItem>,
        existingFavorites: List<UserEntity>
    ): List<UserEntity> {
        val userList = ArrayList<UserEntity>()

        input.map { apiUser ->
            val existingFavorite = existingFavorites.find { it.id == apiUser.id }

            val user = UserEntity(
                id = apiUser.id!!,
                name = apiUser.login,
                image = apiUser.avatarUrl,
                isFavorite = existingFavorite?.isFavorite ?: false
            )

            userList.add(user)
        }

        return userList
    }

    fun mapEntitiesToDomain(input: List<UserEntity>): List<User> =
        input.map {
            User(
                id = it.id,
                name = it.name!!,
                image = it.image!!,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: User) = UserEntity(
        id = input.id,
        name = input.name,
        image = input.image,
        isFavorite = input.isFavorite
    )
}
