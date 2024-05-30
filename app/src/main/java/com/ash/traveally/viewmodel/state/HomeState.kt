package com.ash.traveally.viewmodel.state

import androidx.compose.runtime.mutableStateListOf
import com.ash.traveally.models.Place

data class HomeState(
    val places: List<Place> = mutableStateListOf(),
    val isLoading: Boolean = false,
    val error: Boolean? = null
)