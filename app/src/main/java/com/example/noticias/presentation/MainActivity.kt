package com.example.noticias.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
                    startDestination = LIST_SCREEN_ROUTE
                ) {
                    composable(FORM_SCREEN_ROUTE) { backStackEntry ->
                        val args = backStackEntry.arguments?.getString("id")
                        FormScreen(
                            backStackEntry,
                            modifier = Modifier.padding(),
                            argumento = args.toString()
                        ) {
                            navController.navigate(LIST_SCREEN_ROUTE)
                        }
                    }


                    composable(LIST_SCREEN_ROUTE) {
                        Scaffold(floatingActionButton = {
                            FloatingActionButton(onClick = {
                                navController.navigate(
                                    FORM_SCREEN_ROUTE
                                )
                            }) {
                                Text(
                                    text = "Cadastrar noticia",
                                    modifier = Modifier.padding(horizontal = 16.dp)
                                )
                            }
                        }) { padding ->
                            ListScreen(
                                modifier = Modifier.padding(padding),
                                navigateTo = { route ->
                                    Log.d("ARUGMENTO", "onCreate: ${route}")
                                    navController.navigate(route)
                                }
                            )
                        }
                    }



                }
            }
        }
    }
}



