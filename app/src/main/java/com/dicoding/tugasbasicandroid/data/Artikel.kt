package com.dicoding.tugasbasicandroid.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artikel(val nama: String, val deskripsi: String, val gambar: Int): Parcelable
