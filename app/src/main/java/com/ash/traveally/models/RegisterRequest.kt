package com.ash.traveally.models

data class RegisterRequest(
    val email: String,
    val password: String,
    val username: String,
    val phoneNumber: String
)