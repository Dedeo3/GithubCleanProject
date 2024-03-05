package com.dicoding.core.di

import androidx.room.Room
import com.dicoding.core.data.UserRepository
import com.dicoding.core.data.local.LocalDataSource
import com.dicoding.core.data.local.room.UserDb
import com.dicoding.core.data.remote.RemoteDataSource
import com.dicoding.core.data.remote.retrofit.ApiService
import com.dicoding.core.domain.interface_repository.InterfaceUserRepository
import com.dicoding.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<UserDb>().userDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            UserDb::class.java, "user.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    val github= "https://api.github.com/"
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(github)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<InterfaceUserRepository> {
        UserRepository(
            get(),
            get(),
            get()
        )
    }
}