package com.example.mvvmcompose.compose

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.mvvmcompose.activity.DetailActivity.Companion.TEST_LINK
import com.example.mvvmcompose.data.user.DataModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.platform.LocalContext


@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun DetailActivityScreen(dataModel: DataModel) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        item { ToolbarDetail() }
        item { ImageHeader(TEST_LINK) }
        item { CharacteristicCell("Name", dataModel.name) }
        item { CharacteristicCell("Email", dataModel.email) }
        item { CharacteristicCell("Gender", dataModel.gender) }
        item { CharacteristicCell("Status", dataModel.status) }
    }
}

@Composable
fun ImageHeader(url: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = rememberImagePainter(url),
            contentDescription = null,
            modifier = Modifier.size(128.dp),
        )
    }
}

@Composable
fun CharacteristicCell(title: String, value: String) {
    Column(modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 0.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 24.dp)
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                modifier = Modifier.weight(0.3f),
                style = TextStyle(color = Color.Black)
            )
            Text(
                text = value,
                modifier = Modifier
                    .weight(0.7f)
                    .padding(8.dp), style = TextStyle(color = Color.Black)
            )
        }

        Divider(color = Color.DarkGray)
    }
}

@Preview
@Composable
fun ToolbarDetail() {
    val activity = (LocalContext.current as? Activity)
    TopAppBar(
        title = {
            Text(text = "Detail Activity")
        },
        navigationIcon = {
            IconButton(onClick = { activity!!.finish() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Menu Btn"
                )
            }
        },
        backgroundColor = Color.Transparent,
        contentColor = Color.Gray,
        elevation = 2.dp
    )
}