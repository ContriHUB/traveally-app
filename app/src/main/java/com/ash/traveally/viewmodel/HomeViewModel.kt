package com.ash.traveally.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ash.traveally.models.Place
import com.ash.traveally.repository.PlaceRepository
import com.ash.traveally.utils.NetworkResult
import com.ash.traveally.viewmodel.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PlaceRepository
): ViewModel() {

    var homeState: HomeState by mutableStateOf(HomeState())

    init { getAllPlaces() }

    fun clearError() {
        homeState = homeState.copy(error = null)
    }

    fun getAllPlaces() {
        viewModelScope.launch {
            homeState = homeState.copy(isLoading = true)
            val response = repository.getAllPlaces()
            homeState = when (response) {
                is NetworkResult.Error -> homeState.copy(error = true, isLoading = false)
                is NetworkResult.Success -> {
                    val places = response.data!!
                    homeState.copy(places = places, isLoading = false)
                }
            }
        }
    }

    fun likePlace(place: Place) {
        viewModelScope.launch {
            homeState = homeState.copy(isLoading = true)
            place.isFavourite = !place.isFavourite
            val response = repository.updatePlace(place)
            when (response) {
                is NetworkResult.Error -> {
                    homeState = homeState.copy(error = true, isLoading = false)
                    place.isFavourite = !place.isFavourite
                }
                is NetworkResult.Success -> {
                    homeState = homeState.copy(isLoading = false)
                }
            }
        }
    }
}