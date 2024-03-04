package com.dicoding.core.data.local

import com.dicoding.core.data.local.entity.UserEntity
import com.dicoding.core.data.local.room.UserDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val dao: UserDao) {

    fun getAllTourism(): Flow<List<UserEntity>> = dao.getAllUser()

//    fun getFavoriteTourism(): Flow<List<TourismEntity>> = tourismDao.getFavoriteTourism()

//    suspend fun insertTourism(tourismList: List<TourismEntity>) = tourismDao.insertTourism(tourismList)

//    fun setFavoriteTourism(tourism: TourismEntity, newState: Boolean) {
//        tourism.isFavorite = newState
//        tourismDao.updateFavoriteTourism(tourism)
//    }
}