package com.ash.traveally.models

data class Blog(
    var id: Long,
    var author: User,
    var city: String,
    var country: String,
    var title: String,
    var introduction: String,
    var description: String,
    var isFavourite: Boolean,
    var isSaved: Boolean,
    var likes: Int,
    var placePhoto: String,
    var time: Long
)