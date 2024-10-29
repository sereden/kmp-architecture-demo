package example.presentation.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import example.domain.user.UserViewModel
import example.presentation.main.LocalProviders
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun UserScreen(
    viewModel: UserViewModel = koinViewModel()
) {
    val state by viewModel.screen.collectAsStateWithLifecycle()
    val navController = LocalProviders.LocalNavControllerProvider.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().statusBarsPadding()
    ) {
        if (state.user == null) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth()
            )
        }
        Text("User: ${state.user?.id.orEmpty()} create at: ${state.user?.createAt ?: "N/A"}")
        OutlinedButton({
            navController.navigate("payment")
        }) {
            Text("Navigate to payment screen")
        }
    }
}