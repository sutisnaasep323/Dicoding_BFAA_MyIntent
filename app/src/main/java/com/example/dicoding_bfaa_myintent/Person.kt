package com.example.dicoding_bfaa_myintent

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    @JvmField val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable