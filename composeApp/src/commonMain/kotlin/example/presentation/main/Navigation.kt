package example.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import example.presentation.user.UserScreen

@Composable
fun Navigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "root",
        modifier = Modifier
            .fillMaxSize()
    ) {
        navigation(
            route = "root",
            startDestination = "user"
        ) {
            composable("user") {
                UserScreen()
            }
        }
    }
}