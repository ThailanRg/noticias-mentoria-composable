package com.example.noticias.presentation.screen.form

sealed interface FormIntent {
    data class TitleChange(var value:String) : FormIntent
    data class DescriptionChange(var value:String) : FormIntent
    data class MensageChange(var value:String) : FormIntent
}