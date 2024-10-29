package example.presentation.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import example.domain.user.UserViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun UserScreen(
    viewModel: UserViewModel = koinViewModel()
) {
    val state by viewModel.screen.collectAsStateWithLifecycle()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        if (state.user == null) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth()
            )
        }
        Text("User: ${state.user?.id.orEmpty()} create at: ${state.user?.createAt ?: "N/A"}")
    }
}