package com.dicoding.core.data.remote

import android.util.Log
import com.dicoding.core.data.remote.response.ApiResponse
import com.dicoding.core.data.remote.response.DetailUserResponse
import com.dicoding.core.data.remote.response.ItemsItem
import com.dicoding.core.data.remote.retrofit.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource (private val apiService: ApiService) {

    suspend fun getAllUser(): Flow<ApiResponse<List<ItemsItem>>> {
        //get data from remote api
        return flow {
            try {
                val response = apiService.getUser("aryo")
                val dataArray = response.items
                if (dataArray!!.isNotEmpty()){
                    emit(ApiResponse.Success(response.items))
                    Log.d("remote data:","success to fetch data")
                } else {
                    emit(ApiResponse.Empty)
                    Log.e("remote data: ","kosong")
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

}