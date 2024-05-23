package com.ash.traveally.viewmodel.state

import com.ash.traveally.models.Message


data class RegisterState(
    val email: String = "",
    val password: String = "",
    val username: String = "",
    val phoneNumber: String = "",
    val confirmPassword: String = "",
    val message: Message? = null,
    val isLoading: Boolean = false,
    val isValidEmail: Boolean? = null,
    val isValidUsername: Boolean? = null,
    val isValidPhoneNumber: Boolean? = null,
    val isValidPassword: Boolean? = null,
    val isValidConfirmPassword: Boolean? = null,
    val error: String? = null,
    val isRegisteredIn: Boolean = false,
)