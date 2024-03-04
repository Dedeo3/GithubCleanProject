package com.dicoding.core.utils

import com.dicoding.core.data.local.entity.UserEntity
import com.dicoding.core.data.remote.response.ItemsItem
import com.dicoding.core.data.remote.response.UserResponse

object DataMapper {
    fun mapResponsesToEntities(input: List<ItemsItem>): List<UserEntity> {
        val userList = ArrayList<UserEntity>()
        input.map {
            val user = UserEntity(
                id=it.id,
                name = it.login,
                image = it.avatarUrl,
                isFavorite = false
            )
            userList.add(user)
        }
        return userList
    }

//    fun mapEntitiesToDomain(input: List<TourismEntity>): List<Tourism> =
//        input.map {
//            Tourism(
//                tourismId = it.tourismId,
//                description = it.description,
//                name = it.name,
//                address = it.address,
//                latitude = it.latitude,
//                longitude = it.longitude,
//                like = it.like,
//                image = it.image,
//                isFavorite = it.isFavorite
//            )
//        }
//
//    fun mapDomainToEntity(input: Tourism) = TourismEntity(
//        tourismId = input.tourismId,
//        description = input.description,
//        name = input.name,
//        address = input.address,
//        latitude = input.latitude,
//        longitude = input.longitude,
//        like = input.like,
//        image = input.image,
//        isFavorite = input.isFavorite
//    )
}