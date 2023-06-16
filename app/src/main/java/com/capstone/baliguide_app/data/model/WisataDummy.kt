package com.capstone.baliguide_app.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WisataDummy (
    val name: String,
    val ratings: String,
    val location: String,
    val price: String,
    val photo: String,
) : Parcelable