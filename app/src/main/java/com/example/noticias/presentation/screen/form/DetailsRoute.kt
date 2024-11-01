package com.example.noticias.presentation.screen.form

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.noticias.presentation.FORM_SCREEN_ROUTE
import com.example.noticias.presentation.LIST_SCREEN_ROUTE

fun NavGraphBuilder.navigateToForm(
    navigateTo: (String) -> Unit = {}
) {
    composable(FORM_SCREEN_ROUTE) { backStackEntry ->
        val args = backStackEntry.arguments?.getString("id")
        val viewModel: FormViewModel = viewModel()
        val uiState = viewModel.uiState.collectAsState(initial = FormViewModel.FormUiState())
        FormScreen(
            uiState = uiState.value,
            modifier = Modifier.padding(),
            args = args.toString(),
            event = viewModel::handleIntent
        ) {
            navigateTo(LIST_SCREEN_ROUTE)
        }
    }
}