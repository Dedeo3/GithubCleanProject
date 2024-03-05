package com.dicoding.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val name:String,
    val image:String,
    val isFavorite: Boolean
):Parcelable

