package com.example.mvvmcompose.view_model

import androidx.lifecycle.ViewModel
import com.example.mvvmcompose.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: MainRepository) : ViewModel(){




}