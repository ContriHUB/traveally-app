package com.ash.traveally.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ash.traveally.models.RegisterRequest
import com.ash.traveally.repository.UserRepository
import com.ash.traveally.utils.AuthValidator
import com.ash.traveally.utils.NetworkResult
import com.ash.traveally.viewmodel.state.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    var registerState: RegisterState by mutableStateOf(RegisterState())

    fun setEmail(email: String) {
        registerState = registerState.copy(email = email)
    }

    fun setUsername(username: String) {
        registerState = registerState.copy(username = username)
    }

    fun setPhoneNumber(phoneNumber: String) {
        registerState = registerState.copy(phoneNumber = phoneNumber)
    }

    fun setPassword(password: String) {
        registerState = registerState.copy(password = password)
    }

    fun setConfirmPassword(confirmPassword: String) {
        registerState = registerState.copy(confirmPassword = confirmPassword)
    }

    fun clearError() {
        registerState = registerState
            .copy(error = null)
    }

    fun registerUser() {
        if (!validateCredentials()) return
        viewModelScope.launch {
            registerState = registerState.copy(isLoading = true)
            val registerRequest = RegisterRequest(
                email = registerState.email,
                password = registerState.password,
                username = registerState.username,
                phoneNumber = registerState.phoneNumber
            )
            val response = repository.registerUser(registerRequest)
            registerState = when (response) {
                is NetworkResult.Error -> registerState.copy(error = response.message, isLoading = false, isRegisteredIn = false)
                is NetworkResult.Success -> {
                    registerState.copy(message = response.data, isLoading = false, isRegisteredIn = true)
                }
            }
        }
    }

    private fun validateCredentials(): Boolean {
        val isValidEmail = AuthValidator.isValidEmail(registerState.email)
        val isValidPassword = AuthValidator.isValidPassword(registerState.password)
        val isValidUsername = AuthValidator.isValidUsername(registerState.username)
        val isValidPhoneNumber = AuthValidator.isValidPhoneNumber(registerState.phoneNumber)
        val arePasswordAndConfirmPasswordSame = AuthValidator.arePasswordAndConfirmPasswordSame(
            registerState.password,
            registerState.confirmPassword
        )
        registerState = registerState.copy(
            isValidEmail = isValidEmail,
            isValidPassword = isValidPassword,
            isValidUsername = isValidUsername,
            isValidPhoneNumber = isValidPhoneNumber,
            isValidConfirmPassword = arePasswordAndConfirmPasswordSame
        )

        return isValidEmail && isValidPassword && isValidUsername && isValidPhoneNumber && arePasswordAndConfirmPasswordSame
    }

}