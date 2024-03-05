package com.dicoding.core.data.remote.retrofit

import com.dicoding.core.data.remote.response.DetailUserResponse
import com.dicoding.core.data.remote.response.UserResponse

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
//    @Headers("Authorization: token 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")
    @GET("search/users")
    suspend fun getUser(
        @Query("q")
        keyword: String
    ): UserResponse
}