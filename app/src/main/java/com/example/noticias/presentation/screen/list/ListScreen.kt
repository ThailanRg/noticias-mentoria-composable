package com.example.noticias.presentation.screen.list

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noticias.R
import com.example.noticias.data.local.DataBase

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    navigateTo : (String) -> Unit = {}
) {
    val newsList = DataBase().readDb()

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(
            count = newsList.size,
        ) { position ->
            val item = newsList[position]
            NewsItem(navigateTo, position, item)
        }
    }
}

@Composable
fun NewsItem(
    navigateTo: (String) -> Unit = {},
    position: Int,
    news: String
) {
    Column(
        modifier = Modifier
            .border(0.1.dp, Color.Black, shape = RoundedCornerShape(percent = 10))
            .fillMaxWidth()
            .background(
                if (isPair(position)) {
                    Color.White
                } else {
                    colorResource(R.color.gray_light)
                }
            )
            .padding(8.dp)
    ) {
        Text(text = news)
        Button(
            onClick = {navigateTo("")},
            modifier = Modifier
                .align(alignment = Alignment.End)
        ) {
            Text(text = "Editar")
        }
    }
}

@Composable
@Preview
fun NewsItemPreview() {
    NewsItem({}, 0, "Titulo")
}

@Composable
@Preview
fun ListScreenPreview() {
    ListScreen()
}

fun isPair(value: Int) = value % 2 == 0
