package com.ash.traveally.models

data class Place(
    var id: Long,
    var name: String,
    var city: String,
    var country: String,
    var description: String,
    var price: Int,
    var rating: Float,
    var isFavourite: Boolean,
    var placePhoto: String,
    var hotelPhoto: String,
    var hasWifi: Boolean,
    var hasFood: Boolean,
    var hasTV: Boolean,
    var hasPool: Boolean,
    var hasSpa: Boolean,
    var hasLaundry: Boolean,
    var hostId: Long,
)

val placeItem = Place(
    id = 2,
    name = "Luxury Resort",
    city = "Maui",
    country = "USA",
    description = "Nestled amidst the lush tropical landscapes of Maui, our luxury resort embodies the essence of paradise. With sweeping views of the azure Pacific Ocean and pristine white sandy beaches, every moment spent here is a testament to indulgence and relaxation. Immerse yourself in the serenity of our meticulously designed accommodations, where contemporary elegance meets Hawaiian charm.",
    price = 300,
    rating = 4.8f,
    isFavourite = true,
    placePhoto = "https://unsplash.com/photos/UDyF0_Frxqs/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8M3x8ZWlmZmVsJTIwdG93ZXJ8ZW58MHx8fHwxNzE2MzUxMDE2fDA&force=true",
    hotelPhoto = "https://unsplash.com/photos/UDyF0_Frxqs/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8M3x8ZWlmZmVsJTIwdG93ZXJ8ZW58MHx8fHwxNzE2MzUxMDE2fDA&force=true",
    hasWifi = true,
    hasFood = true,
    hasSpa = true,
    hasPool = true,
    hasTV = true,
    hasLaundry = true,
    hostId = 3
)
