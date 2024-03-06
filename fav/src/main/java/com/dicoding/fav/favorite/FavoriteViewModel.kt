package com.dicoding.fav.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.core.domain.use_case.UserUseCase

class FavoriteViewModel (useCase: UserUseCase) : ViewModel() {
    val favorite= useCase.getFavorite().asLiveData()
}