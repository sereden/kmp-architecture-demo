package data.network.api.model

data class NetworkErrorData(val message: String, val arguments: Map<String, Any?>? = emptyMap())
