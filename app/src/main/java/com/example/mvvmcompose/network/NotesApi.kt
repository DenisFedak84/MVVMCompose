package com.example.mvvmcompose.network

import com.example.mvvmcompose.data.user.UserResponse

import io.reactivex.Observable
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.Flow

interface NotesApi {



    @GET("/public/v1/users")
    suspend fun getUsers(): UserResponse

    @GET("/public/v1/users")
    suspend fun getPaginationUsers(@Query("page") pageNumber: Int): UserResponse
}
