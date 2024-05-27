package com.ash.traveally.models

data class Message(
    val id: Long,
    val message: String,
    val time: Long,
    val userId: Long
)
val messageItem1 = Message(
    id = 1,
    message = "Hello, world!",
    time = System.currentTimeMillis(),
    userId = 0
)
val messageItem2 = Message(
    id = 2,
    message = "Hello, world!",
    time = System.currentTimeMillis(),
    userId = 1
)
