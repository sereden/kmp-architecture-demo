package example.presentation.main

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController

object LocalProviders {
    val LocalNavControllerProvider = staticCompositionLocalOf<NavHostController> {
        throw IllegalStateException("Provision required")
    }
}
