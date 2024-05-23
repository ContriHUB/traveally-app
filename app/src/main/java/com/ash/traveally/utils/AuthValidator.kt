package com.ash.traveally.utils

import android.util.Patterns

object AuthValidator {
    fun isValidEmail(email: String): Boolean = email.trim().length in (4..30) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    fun isValidPassword(password: String): Boolean = password.trim().length in (8..50)
    fun isValidUsername(username: String): Boolean = username.all { it.isLetter() }
    fun isValidPhoneNumber(phoneNumber: String): Boolean =  phoneNumber.length in (10..14) && phoneNumber.all { it.isDigit() }
    fun arePasswordAndConfirmPasswordSame(password: String, confirmPassword: String): Boolean = password.equals(confirmPassword)
}