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
import androidx.compose.ui.tooling.preview.Preview
import com.example.noticias.data.local.DataBase

@Composable
fun FormScreen(
    navigateTo : (String) -> Unit = {}
) {

    var title by rememberSaveable  { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
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
                DataBase().createDb(title)
               navigateTo("")
            }
        ) {
            Text("cadastrar")
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
        label = { Text(label) },
        onValueChange = {
            onEmailChange(it)
        }
    )
}

@Composable
@Preview
fun FormScreenPreview(
    navigateTo : (String) -> Unit = {}
) {
    FormScreen()
}
