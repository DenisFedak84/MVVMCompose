package com.example.mvvmcompose.data.user

import java.io.Serializable

data class DataModel(
    val id: String,
    val name: String,
    val email: String,
    val gender: String,
    val status: String,
):Serializable
