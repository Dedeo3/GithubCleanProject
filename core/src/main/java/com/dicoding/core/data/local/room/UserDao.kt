package com.dicoding.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.dicoding.core.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAllUser(): Flow<List<UserEntity>>

//    @Query("SELECT * FROM tourism where isFavorite = 1")
//    fun getFavoriteTourism(): Flow<List<TourismEntity>>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertTourism(tourism: List<TourismEntity>)
//
//    @Update
//    fun updateFavoriteTourism(tourism: TourismEntity)
}