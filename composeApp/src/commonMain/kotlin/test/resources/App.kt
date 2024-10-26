package test.resources

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import test.resources.screen.UserScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            UserScreen()
        }
    }
}

