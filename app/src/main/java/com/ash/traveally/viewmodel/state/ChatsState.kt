package com.ash.traveally.viewmodel.state

import androidx.compose.runtime.mutableStateListOf
import com.ash.traveally.models.User

data class ChatsState(
    val users: MutableList<User> = mutableStateListOf(),
    val isLoading: Boolean = false,
    val error: Boolean? = null
)
