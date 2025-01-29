package com.example.idealistachallengefranciscogaitan.utils

sealed class ResponseState<T>(val data: T? = null, val message: String? = null) {

    companion object {
        const val SERVER_DEFAULT_ERROR = "Error de servidor"
        const val INTERNET_ERROR = "Error de conexión"
        const val UNEXPECTED_ERROR = "An Unexpected Error"
    }

    class Loading<T>(data: T? = null) : ResponseState<T>(data)

    class Success<T>(data: T) : ResponseState<T>(data)

    class Error<T>(message: String, data: T? = null) : ResponseState<T>(data, message)
}
