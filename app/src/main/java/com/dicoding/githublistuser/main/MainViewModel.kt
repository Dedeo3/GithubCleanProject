package com.dicoding.githublistuser.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.core.domain.use_case.UserUseCase

class MainViewModel (private val useCase: UserUseCase) : ViewModel() {
    fun user()=useCase.getAllUser().asLiveData()

}