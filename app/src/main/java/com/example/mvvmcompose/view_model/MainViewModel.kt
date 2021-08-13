package com.example.mvvmcompose.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcompose.data.user.DataModel
import com.example.mvvmcompose.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private val data: LiveData<List<DataModel>>
        get() = dataLiveData
    private val dataLiveData by lazy { MutableLiveData<List<DataModel>>() }

    private val progress: LiveData<Boolean>
        get() = progressLiveData
    private val progressLiveData by lazy { MutableLiveData<Boolean>() }

    fun getSuccessResponse(): LiveData<List<DataModel>> {
        return data
    }

    private fun setSuccessRestResponse(response: List<DataModel>) {
        dataLiveData.postValue(response)
    }

    fun getMyProgress() : LiveData<Boolean>{
        return progress
    }

    private fun setMyProgress(prgress:Boolean){
        progressLiveData.postValue(prgress)
    }

    fun getNotes( ){
        setMyProgress(true)
        viewModelScope.launch {
            delay(2000)
            val response = repository.getDataFromREST()
            setMyProgress(false)
            setSuccessRestResponse(response = response)
        }
    }
}