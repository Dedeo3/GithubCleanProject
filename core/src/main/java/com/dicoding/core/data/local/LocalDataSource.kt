package com.dicoding.core.data.local

import android.content.SharedPreferences
import com.dicoding.core.data.local.entity.UserEntity
import com.dicoding.core.data.local.room.UserDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val dao: UserDao) {

    fun getAllUser(): Flow<List<UserEntity>> = dao.getAllUser()

    fun getFavoriteTourism(): Flow<List<UserEntity>> = dao.getFavorite()

    suspend fun insertUser(list: List<UserEntity>) = dao.insertUser(list)

    fun setFavorite(user: UserEntity, newState: Boolean) {
       user.isFavorite = newState
        dao.updateFavorite(user)
    }
}