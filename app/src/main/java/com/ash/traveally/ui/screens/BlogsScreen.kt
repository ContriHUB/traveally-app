package com.ash.traveally.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ash.traveally.R
import com.ash.traveally.models.Blog
import com.ash.traveally.models.blogItem
import com.ash.traveally.ui.components.items.BlogItem
import com.ash.traveally.ui.components.text.SearchBar

@Composable
fun BlogsScreen(
    onItemClick: (Blog) -> Unit,
    onAddBlogClick: () -> Unit
) {
    var search by remember { mutableStateOf("") }
    Column {
        SearchBar(searchText = search, onSearchTextChanged = { search = it }, modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp))
        LazyVerticalGrid(
            columns = GridCells.Adaptive(512.dp),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(blogs) { blog ->
                BlogItem(blog = blog, onItemClick = onItemClick)
            }
        }
    }
    Column (
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        FloatingActionButton(
            onClick = { }
        ) {
            Icon(painterResource(id = R.drawable.ic_bookmark),"")
        }
        Spacer(modifier = Modifier.padding(8.dp))
        FloatingActionButton(
            onClick = onAddBlogClick
        ) {
            Icon(Icons.Filled.Add,"")
        }
    }
}

val blogs = listOf(blogItem, blogItem, blogItem, blogItem, blogItem, blogItem, blogItem, blogItem, blogItem)