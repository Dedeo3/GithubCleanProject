package com.dicoding.core.utils

import com.dicoding.core.data.local.entity.UserEntity
import com.dicoding.core.data.remote.response.ItemsItem
import com.dicoding.core.data.remote.response.UserResponse
import com.dicoding.core.domain.model.User

object DataMapper {
    fun mapResponsesToEntities(input: List<ItemsItem>): List<UserEntity> {
        val userList = ArrayList<UserEntity>()
        input.map {
            val user = UserEntity(
                id=it.id!!,
                name = it.login,
                image = it.avatarUrl,
                isFavorite = false
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
                isFavorite = false
            )
        }
//
    fun mapDomainToEntity(input: User) = UserEntity(
        id = input.id,
        name = input.name,
        image = input.image,
        isFavorite = false
    )
}