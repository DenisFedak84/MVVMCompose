package com.example.mvvmcompose.view_model

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.mvvmcompose.data.user.DataModel
import com.example.mvvmcompose.pagination.UserSource
import com.example.mvvmcompose.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class PaginationViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    val users: Flow<PagingData<DataModel>> = Pager(PagingConfig(pageSize = 20)) {

        UserSource(repository)
    }.flow
}