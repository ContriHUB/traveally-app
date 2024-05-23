package com.ash.traveally.models

data class Place(
    val name: String,
    val city: String,
    val country: String,
    val rating: Float,
    val isFavourite: Boolean,
    val url: String
)
