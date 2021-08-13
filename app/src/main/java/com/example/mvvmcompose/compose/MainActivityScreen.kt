package com.example.mvvmcompose.compose

import android.annotation.SuppressLint
import android.content.Intent
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvmcompose.activity.DetailActivity
import com.example.mvvmcompose.activity.MainActivity
import com.example.mvvmcompose.activity.MainActivity.Companion.USER_DATA
import com.example.mvvmcompose.activity.PaginationActivity
import com.example.mvvmcompose.data.user.DataModel
import com.example.mvvmcompose.view_model.MainViewModel
import kotlinx.coroutines.delay

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun MainActivityScreen(mainViewModel: MainViewModel = viewModel()) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Toolbar()
        DrawList(mainViewModel)
        CircularIndeterminateProgressBar(mainViewModel)

    }
}

@Preview
@Composable
fun Toolbar() {
    TopAppBar(
        title = {
            Text(text = "Main Activity")
        },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu Btn"
                )
            }
        },
        backgroundColor = Color.Transparent,
        contentColor = Color.Gray,
        elevation = 2.dp
    )
}

@Preview
@Composable
fun DrawList(mainViewModel: MainViewModel) {
    val data by mainViewModel.getSuccessResponse().observeAsState(mutableListOf())

    LazyColumn(Modifier.padding(16.dp, 8.dp, 16.dp, 8.dp)) {

        items(data) { item ->
            MainItem(item = item)
        }

        item { PaginationButton(mainViewModel) }
    }
}

@Preview
@Composable
fun MainItem(item: DataModel) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .height(44.dp)
            .fillMaxWidth()
            .padding(4.dp)
            .clickable {
//                Toast.makeText(context, "${item.email} info click", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(USER_DATA,item)
                context.startActivity(Intent(intent))
            }
            .background(color = MaterialTheme.colors.secondary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(4.dp),
            text = item.name,
            style = TextStyle(color = Color.Black)
        )
    }
}

@Composable
fun CircularIndeterminateProgressBar(mainViewModel: MainViewModel) {
    val isDisplayed by mainViewModel.getMyProgress().observeAsState(initial = true)

    if (isDisplayed) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                color = MaterialTheme.colors.primary
            )
        }
    }
}

@Composable
fun PaginationButton(mainViewModel: MainViewModel) {
    val context = LocalContext.current
    val isDisplayedProgress by mainViewModel.getMyProgress().observeAsState(initial = true)

    if (!isDisplayedProgress){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    context.startActivity(Intent(context, PaginationActivity::class.java))
                },
                modifier = Modifier
                    .background(
                        color = MaterialTheme.colors.background,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .height(48.dp)
                    .width(260.dp)
                    .padding(end = 24.dp),

                ) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text(
                        "Go to Pagination",
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp
                        )
                    )
                }
            }
        }
    }
}



