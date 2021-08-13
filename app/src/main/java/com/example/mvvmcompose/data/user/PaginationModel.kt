package com.example.mvvmcompose.data.user

data class PaginationModel(
    val total: Int,
    val pages: Int,
    val page: Int,
    val limit: Int,
    val links:LinksModel
)
