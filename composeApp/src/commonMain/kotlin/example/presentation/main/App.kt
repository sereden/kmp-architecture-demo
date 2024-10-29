package example.presentation.main

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import example.presentation.user.UserScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            Navigation(rememberNavController())
        }
    }
}

