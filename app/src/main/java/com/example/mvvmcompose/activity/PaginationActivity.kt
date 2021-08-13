package com.example.mvvmcompose.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmcompose.compose.PaginationActivityScreen
import com.example.mvvmcompose.ui.theme.MVVMComposeTheme
import com.example.mvvmcompose.view_model.PaginationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaginationActivity : AppCompatActivity() {

    private val paginationViewModel: PaginationViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MVVMComposeTheme {
                PaginationActivityScreen(paginationViewModel)
            }
        }

    }



}