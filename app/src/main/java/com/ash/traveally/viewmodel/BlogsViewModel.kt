package com.ash.traveally.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ash.traveally.models.Blog
import com.ash.traveally.repository.BlogRepository
import com.ash.traveally.utils.NetworkResult
import com.ash.traveally.viewmodel.state.BlogsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlogsViewModel @Inject constructor(
    private val repository: BlogRepository
) : ViewModel() {

    var blogsState: BlogsState by mutableStateOf(BlogsState())

    init { getAllBlogs() }

    fun clearError() {
        blogsState = blogsState.copy(error = null)
    }

    fun getAllBlogs() {
        viewModelScope.launch {
            blogsState = blogsState.copy(isLoading = true)
            val response = repository.getAllBlogs()
            blogsState = when (response) {
                is NetworkResult.Error -> blogsState.copy(error = true, isLoading = false)
                is NetworkResult.Success -> {
                    val blogs = response.data!!
                    blogsState.copy(blogs = blogs, isLoading = false)
                }
            }
        }
    }

    fun likeBlog(blog: Blog) {
        viewModelScope.launch {
            blogsState = blogsState.copy(isLoading = true)
            blog.isFavourite = !blog.isFavourite
            val response = repository.updateBlog(blog)
            when (response) {
                is NetworkResult.Error -> {
                    blogsState = blogsState.copy(error = true, isLoading = false)
                    blog.isFavourite = !blog.isFavourite
                }
                is NetworkResult.Success -> {
                    val data = response.data!!
                    blogsState = blogsState.copy(isLoading = false)
                    blog.likes = data.likes
                }
            }
        }
    }
}
