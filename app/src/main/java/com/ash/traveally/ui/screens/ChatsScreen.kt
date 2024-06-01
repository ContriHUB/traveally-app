package com.ash.traveally.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.ash.traveally.models.User
import com.ash.traveally.ui.components.dialog.FailureDialog
import com.ash.traveally.ui.components.dialog.LoaderDialog
import com.ash.traveally.ui.components.items.ChatItem
import com.ash.traveally.ui.components.text.SearchBar
import com.ash.traveally.viewmodel.ChatsViewModel
import com.ash.traveally.viewmodel.state.ChatsState

@Composable
fun ChatsScreen(
    viewModel: ChatsViewModel = hiltViewModel(),
    onDialogDismiss: () -> Unit = viewModel::clearError,
    onItemClick: (User) -> Unit
) {
    var search by remember { mutableStateOf("") }
    val state: ChatsState = viewModel.chatsState

    if (state.isLoading) {
        LoaderDialog()
    }

    if (state.error != null) {
        FailureDialog("Something went wrong", onDialogDismiss = onDialogDismiss)
    }
    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxHeight()
    ) {
        item {
            SearchBar(searchText = search, onSearchTextChanged = { search = it }, modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp))
        }
        items(state.users) {
            ChatItem(it, onItemClick)
        }
    }
}