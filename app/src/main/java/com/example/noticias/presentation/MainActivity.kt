package com.example.noticias.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noticias.presentation.screen.form.FormScreen
import com.example.noticias.presentation.screen.list.ListScreen
import com.example.noticias.presentation.theme.NoticiasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoticiasTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = FORM_SCREEN_ROUTE
                ) {
                    composable(FORM_SCREEN_ROUTE) {
                        FormScreen {
                            navController.navigate(LIST_SCREEN_ROUTE)
                        }
                    }
                    composable(LIST_SCREEN_ROUTE) {
                        ListScreen()
                    }
                }
            }
        }
    }
}



