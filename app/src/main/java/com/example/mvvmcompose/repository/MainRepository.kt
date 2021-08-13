package com.example.mvvmcompose.repository

import com.example.mvvmcompose.data.user.DataModel
import com.example.mvvmcompose.data.user.UserResponse
import com.example.mvvmcompose.network.NotesApi
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val api: NotesApi,
) {

    suspend fun getDataFromREST(): List<DataModel> {

        var rest: UserResponse? = null

        try {
            rest = api.getUsers()
        } catch (e: Exception) {
            println("Error")
        }

        return if (rest?.data != null) {
            rest.data
        } else {
            emptyList()
        }
    }


    suspend fun getPaginationDataFromREST(pageNumber: Int) = api.getPaginationUsers(pageNumber = pageNumber)

}