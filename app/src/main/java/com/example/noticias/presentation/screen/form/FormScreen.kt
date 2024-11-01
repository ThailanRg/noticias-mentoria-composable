package com.example.noticias.presentation.screen.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import com.example.noticias.data.local.DataBase
import com.example.noticias.data.local.News

@Composable
fun FormScreen(
    navController: NavBackStackEntry,
    argumento: String = "",
    modifier: Modifier = Modifier,
    navigateTo: (String) -> Unit = {}
) {
    val itemCurrent = DataBase().findItem(argumento)

    var title by rememberSaveable { mutableStateOf(itemCurrent?.title ?: "") }
    var description by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = CenterHorizontally
    ) {

        Forms("Titulo", title) {
            title = it
        }

        Forms("Descricao", description) {
            description = it
        }

        Forms("mensagem", message) {
            message = it
        }

        Button(
            onClick = {
                if(itemCurrent != null) {
                    DataBase().update(
                        key = argumento,
                        update = News(title = title)
                    )
                } else {
                    DataBase().create(News(
                        title = title,
                        description = description,
                        message = message
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
                    DataBase().delete(key = argumento)
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

