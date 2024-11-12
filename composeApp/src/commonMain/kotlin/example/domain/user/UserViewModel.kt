package example.domain.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.auth.api.domain.security.GenerateEcKeyPairUseCase
import domain.auth.api.domain.user.GetUserUseCase
import example.model.UserScreenEvent
import example.model.UserScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.core.annotation.Factory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Factory
class UserViewModel : ViewModel(), KoinComponent {
    private val getUserUseCase: GetUserUseCase by inject()
    private val generateEcKeyPairUseCase: GenerateEcKeyPairUseCase by inject()
    private val screenState = MutableStateFlow(UserScreenState())
    val screen = screenState.asStateFlow()

    init {
        observeData()
    }

    private fun observeData() = viewModelScope.launch {
        getUserUseCase().collectLatest { result ->
            screenState.update { it.copy(user = result.getOrNull()) }
        }
    }

    fun onEvent(event: UserScreenEvent) {
        when (event) {
            UserScreenEvent.GenerateEcKey -> generateEcKey()
        }
    }

    private fun generateEcKey() = viewModelScope.launch {
        screenState.update { state -> state.copy(keyId = generateEcKeyPairUseCase()) }
    }
}