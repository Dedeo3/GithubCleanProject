package com.dicoding.githublistuser.di

import com.dicoding.core.domain.use_case.UseCaseInteractor
import com.dicoding.core.domain.use_case.UserUseCase
import com.dicoding.githublistuser.detail.DetailViewModel
import com.dicoding.githublistuser.favorite.FavoriteViewModel
import com.dicoding.githublistuser.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<UserUseCase> { UseCaseInteractor(get()) }
}

val viewModelModule = module {
    viewModel { DetailViewModel(get()) }
    viewModel { MainViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
}