package com.example.beginner.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Univ(
    val namaUniv: String,
    val tahunBerdiri: String,
    val deskripsi: String,
    val gambarUrl: Int,
) : Parcelable
