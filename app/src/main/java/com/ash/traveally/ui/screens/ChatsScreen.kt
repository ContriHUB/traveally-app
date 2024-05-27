package com.ash.traveally.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ash.traveally.models.User
import com.ash.traveally.models.userItem
import com.ash.traveally.ui.components.items.ChatItem
import com.ash.traveally.ui.components.text.SearchBar

@Composable
fun ChatsScreen(onItemClick: (User) -> Unit) {
    var search by remember { mutableStateOf("") }
    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxHeight()
    ) {
        item {
            SearchBar(searchText = search, onSearchTextChanged = { search = it }, modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp))
        }
        items(users) {
            ChatItem(it, onItemClick)
        }
    }
}

val users = listOf(userItem, userItem, userItem, userItem, userItem, userItem, userItem, userItem, userItem, userItem)