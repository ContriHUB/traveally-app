package com.ash.traveally.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ash.traveally.repository.UserRepository
import com.ash.traveally.utils.NetworkResult
import com.ash.traveally.viewmodel.state.ProfileState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    var profileState: ProfileState by mutableStateOf(ProfileState())

    init { getUser() }

    fun clearError() {
        profileState = profileState.copy(error = null)
    }

    fun getUser() {
        viewModelScope.launch {
            profileState = profileState.copy(isLoading = true)
            val response = userRepository.getUser()
            profileState = when (response) {
                is NetworkResult.Error -> profileState.copy(error = true, isLoading = false)
                is NetworkResult.Success -> {
                    val user = response.data!!
                    profileState.copy(
                        name = user.name,
                        username = user.username,
                        email = user.email,
                        phoneNumber = user.phoneNumber.toString(),
                        city = user.city,
                        country = user.country,
                        bio = user.bio,
                        photoUrl = user.photoUrl,
                        isLoading = false
                    )
                }
            }
        }
    }
}