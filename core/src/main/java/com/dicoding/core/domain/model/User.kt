package com.dicoding.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: String,
    val name:String,
    val image:String,
    val isFavorite: Boolean
):Parcelable

