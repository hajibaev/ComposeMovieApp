package com.example.composemovieapp.presentation.ui.destinations.nav_graph

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.composemovieapp.presentation.ui.components.items.BottomBarItem

@Composable
fun AppRootScreen(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomBarItem(navController)
        },
    ) { innerPaddings ->
        BottomNavGraph(
            modifier = Modifier.padding(innerPaddings),
            navController = navController,
        )
    }
}