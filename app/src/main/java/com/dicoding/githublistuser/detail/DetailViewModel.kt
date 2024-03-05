package com.dicoding.githublistuser.detail

import androidx.lifecycle.ViewModel
import com.dicoding.core.domain.model.User
import com.dicoding.core.domain.use_case.UserUseCase

class DetailViewModel (private val useCase: UserUseCase) : ViewModel() {
    fun setFavorite(user: User, newStatus:Boolean) =
        useCase.setFavorite(user, newStatus)
}