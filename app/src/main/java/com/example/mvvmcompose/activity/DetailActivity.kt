package com.example.mvvmcompose.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmcompose.activity.MainActivity.Companion.USER_DATA
import com.example.mvvmcompose.compose.DetailActivityScreen
import com.example.mvvmcompose.compose.MainActivityScreen
import com.example.mvvmcompose.data.user.DataModel
import com.example.mvvmcompose.ui.theme.MVVMComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    companion object {
        const val TEST_LINK = "https://picsum.photos/200"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val item = intent.getSerializableExtra(USER_DATA)
        setContent {
            MVVMComposeTheme {
               DetailActivityScreen(item as DataModel)
            }
        }
    }
}