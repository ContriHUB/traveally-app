package com.ash.traveally.viewmodel.state

data class AddBlogState(
    val title: String = "",
    val introduction: String = "",
    val description: String = "",
    val city: String = "",
    val country: String = "",
    val isLoading: Boolean = false,
    val error: Boolean? = null,
    val added: Boolean = false
)