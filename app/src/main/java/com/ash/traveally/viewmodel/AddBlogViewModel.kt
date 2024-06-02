package com.ash.traveally.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ash.traveally.models.Blog
import com.ash.traveally.repository.BlogRepository
import com.ash.traveally.utils.NetworkResult
import com.ash.traveally.viewmodel.state.AddBlogState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddBlogViewModel @Inject constructor(
    private val repository: BlogRepository
): ViewModel() {

    var addBlogState: AddBlogState by mutableStateOf(AddBlogState())

    fun insertBlog() {
        viewModelScope.launch {
            addBlogState = addBlogState.copy(isLoading = true)
            val blog = Blog(
                title = addBlogState.title,
                introduction = addBlogState.introduction,
                description = addBlogState.description,
                city = addBlogState.city,
                country = addBlogState.country
            )
            when (val response = repository.addBlog(blog)) {
                is NetworkResult.Error -> addBlogState =
                    addBlogState.copy(error = true, isLoading = false)
                is NetworkResult.Success -> {
                    addBlogState = addBlogState.copy(added = true)
                }
            }
        }
    }

    fun setTitle(title: String) {
        addBlogState = addBlogState.copy(title = title)
    }

    fun setIntroduction(introduction: String) {
        addBlogState = addBlogState.copy(introduction = introduction)
    }

    fun setDescription(description: String) {
        addBlogState = addBlogState.copy(description = description)
    }

    fun setCity(city: String) {
        addBlogState = addBlogState.copy(city = city)
    }

    fun setCountry(country: String) {
        addBlogState = addBlogState.copy(country = country)
    }

    fun clearError() {
        addBlogState = addBlogState.copy(error = false)
    }
}