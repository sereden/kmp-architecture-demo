package data.network.api.model

sealed class NetworkResult<T> {

    class Success<T>(val data: T) : NetworkResult<T>()
    class Error<T>(val code: NetworkErrorType, val data: NetworkErrorData) : NetworkResult<T>()
}
