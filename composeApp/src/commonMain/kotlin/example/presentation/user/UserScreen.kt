package example.presentation.user

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import domain.auth.api.domain.repository.GetUserUseCase
import domain.auth.api.model.user.User
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun UserScreen(
    getUserUseCase: GetUserUseCase = koinInject()
) {
    val scope = rememberCoroutineScope()
    var user by remember { mutableStateOf<User?>(null) }
    // Move to ViewModel
    LaunchedEffect(Unit) {
        scope.launch {
            getUserUseCase().collectLatest { result ->
                user = result.getOrNull()
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        if (user == null) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth()
            )
        }
        Text("User: ${user?.id.orEmpty()} create at: ${user?.createAt ?: "N/A"}")
    }
}