package com.example.noticias.presentation.screen.list

import androidx.lifecycle.ViewModel
import com.example.noticias.data.local.DataBase
import com.example.noticias.data.local.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class ListViewModel : ViewModel() {

    private var _uiState = MutableStateFlow(ListUiState())
    val uiState : Flow<ListUiState> = _uiState

    init {
        updateList()
    }

    private fun updateList() {
        _uiState.update {
            ListUiState(
                DataBase().readDb()
            )
        }
    }

    data class ListUiState(
        val news: MutableList<News> = mutableListOf()
    )

}