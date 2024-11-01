package com.example.noticias.presentation.screen.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import com.example.noticias.data.local.DataBase
import com.example.noticias.data.local.News

@Composable
fun FormScreen(
    uiState: FormViewModel.FormUiState,
    args: String = "",
    modifier: Modifier = Modifier,
    event:(FormIntent) -> Unit = {},
    navigateTo: (String) -> Unit = {}
) {

    val itemCurrent = DataBase().findItem(args)

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = CenterHorizontally
    ) {

        Forms("Titulo", uiState.title) { title ->
            event(FormIntent.TitleChange(title))
        }

        Forms("Descricao",  uiState.description) {
            event(FormIntent.DescriptionChange(it))
        }

        Forms("mensagem",  uiState.message) {
            event(FormIntent.MensageChange(it))
        }

        Button(
            onClick = {
                if(itemCurrent != null) {
                    DataBase().update(
                        key = args,
                        update = News(title = uiState.title)
                    )
                } else {
                    DataBase().create(News(
                        title = uiState.title,
                        description = uiState.description,
                        message = uiState.message
                    ))
                }
                navigateTo("")
            }
        ) {
            Text(text = if(itemCurrent != null) "atualizar" else "cadastrar")
        }

        if(itemCurrent != null) {
            Button(
                onClick = {
                    DataBase().delete(key = args)
                    navigateTo("")
                }
            ) {
                Text(text = "excluir")
            }
        }
    }
}

@Composable
fun Forms(
    label: String,
    email: String,
    onEmailChange: (String) -> Unit
) {
    OutlinedTextField(
        value = email,
        label = {
            Text(text = label)
        },
        onValueChange = { onEmailChange(it) }
    )
}

