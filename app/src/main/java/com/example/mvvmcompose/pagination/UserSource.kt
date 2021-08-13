package com.example.mvvmcompose.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mvvmcompose.data.user.DataModel
import com.example.mvvmcompose.repository.MainRepository
import kotlinx.coroutines.delay

class UserSource(private val repository: MainRepository) : PagingSource<Int, DataModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataModel> {
        return try {
            val nextPage = params.key ?: 1

            val dataListResponse = repository.getPaginationDataFromREST(nextPage)
            delay(4000)
            LoadResult.Page(
                data = dataListResponse.data,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = dataListResponse.meta.pagination.page.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, DataModel>): Int? {
        TODO("Not yet implemented")
    }


}