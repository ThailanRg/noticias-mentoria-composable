package com.example.noticias.presentation.screen.form

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class FormViewModel : ViewModel() {

    private var _uiState = MutableStateFlow(FormUiState())
    val uiState: Flow<FormUiState> = _uiState

    fun handleIntent(event: FormIntent) {
        when (event) {
            is FormIntent.TitleChange -> titleChange(event.value)
            is FormIntent.DescriptionChange -> descriptionChange(event.value)
            is FormIntent.MensageChange -> messageChange(event.value)
        }
    }

    private fun titleChange(value: String) {
        _uiState.update {
            it.copy(title = value)
        }
    }

    private fun descriptionChange(value: String) {
        _uiState.update {
            it.copy(description = value)
        }
    }

    private fun messageChange(value: String) {
        _uiState.update {
            it.copy(message = value)
        }
    }


    data class FormUiState(
        val title: String = "",
        val description: String = "",
        val message: String = ""
    )
}