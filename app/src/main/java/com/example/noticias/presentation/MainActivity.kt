package com.example.noticias.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.noticias.presentation.screen.form.navigateToDetails
import com.example.noticias.presentation.screen.list.navigateToList
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
                    navigateToDetails {
                        navController.navigate(it)
                    }
                    navigateToList {
                        navController.navigate(it)
                    }
                }
            }
        }
    }
}



