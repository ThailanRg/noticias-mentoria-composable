package com.example.noticias.presentation.screen.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.noticias.presentation.FORM_SCREEN_ROUTE
import com.example.noticias.presentation.LIST_SCREEN_ROUTE
import com.example.noticias.presentation.screen.list.ListViewModel.ListUiState

fun NavGraphBuilder.navigateToList(
    navigateTo: (String) -> Unit = {}
) {
    composable(LIST_SCREEN_ROUTE) {
        Scaffold(floatingActionButton = {
            FloatingActionButton(onClick = {
                navigateTo(FORM_SCREEN_ROUTE)
            }) {
                Text(
                    text = "Cadastrar noticia",
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }) { padding ->

            val viewModel: ListViewModel = viewModel()
            val uiState = viewModel.uiState.collectAsState(initial = ListUiState())

            ListScreen(
                uiState = uiState.value,
                modifier = Modifier.padding(padding),
                navigateTo = { route ->
                    navigateTo(route)
                }
            )
        }
    }
}