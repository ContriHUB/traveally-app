package com.ash.traveally.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ash.traveally.repository.ChatRepository
import com.ash.traveally.repository.UserRepository
import com.ash.traveally.utils.NetworkResult
import com.ash.traveally.viewmodel.state.ChatsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatsViewModel @Inject constructor(
    private val chatRepository: ChatRepository,
    private val userRepository: UserRepository
): ViewModel() {

    var chatsState: ChatsState by mutableStateOf(ChatsState())

    init {
        getAllChats()
    }

    fun clearError() {
        chatsState = chatsState.copy(error = null)
    }

    private fun getAllChats() {
        viewModelScope.launch {
            chatsState = chatsState.copy(isLoading = true)
            val response = chatRepository.getAllChats()
            when (response) {
                is NetworkResult.Error -> chatsState = chatsState.copy(error = true, isLoading = false)
                is NetworkResult.Success -> {
                    val ids = response.data!!
                    for (id in ids) {
                        addUser(id)
                    }
                    chatsState = chatsState.copy(isLoading = false)
                }
            }
        }
    }

    private suspend fun addUser(id: Long) {
        val response = userRepository.getUser(id)
        when (response) {
            is NetworkResult.Error -> chatsState = chatsState.copy(error = true, isLoading = false)
            is NetworkResult.Success -> {
                val user = response.data!!
                chatsState.users.add(user)
            }
        }
    }
}