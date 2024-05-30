package com.ash.traveally.viewmodel.state

data class ProfileState(
    val name: String = "",
    val username: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    val city: String = "",
    val country: String = "",
    val bio: String = "",
    val photoUrl: String = "",
    val isLoading: Boolean = false,
    val error: Boolean? = null
)