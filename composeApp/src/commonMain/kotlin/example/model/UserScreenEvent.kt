package example.model

sealed interface UserScreenEvent {
    data object GenerateEcKey : UserScreenEvent
}