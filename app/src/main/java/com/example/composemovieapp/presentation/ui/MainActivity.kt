package com.example.composemovieapp.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.composemovieapp.presentation.ui.core.colors.MovieTheme
import com.example.composemovieapp.presentation.ui.destinations.nav_graph.AppNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MovieNavApp()
                }
            }
        }
    }
}

@Composable
private fun MovieNavApp() {
    val navController = rememberNavController()
    AppNavGraph(navController = navController)
}