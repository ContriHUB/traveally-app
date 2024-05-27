package com.ash.traveally.models

data class User(
    val name: String,
    val username: String,
    val phoneNumber: Long,
    val email: String,
    val city: String,
    val country: String,
    val photoUrl: String,
    val bio: String
)
val userItem = User(
    name = "John Doe",
    username = "johndoe3",
    email = "john.doe@example.com",
    phoneNumber = 1234567890,
    city = "New York",
    country = "USA",
    photoUrl = "https://images.pexels.com/photos/614810/pexels-photo-614810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
    bio = "I am seasoned travel guide with a decade of experience, transforms trips into extraordinary adventures. From Tokyo's bustling streets to Patagonia's serene landscapes, fostering meaningful connections between travelers and destinations worldwide."
)
