package com.ash.traveally.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ash.traveally.models.Place
import com.ash.traveally.ui.components.dialog.FailureDialog
import com.ash.traveally.ui.components.dialog.LoaderDialog
import com.ash.traveally.ui.components.items.PlaceItem
import com.ash.traveally.ui.components.text.SearchBar
import com.ash.traveally.viewmodel.HomeViewModel
import com.ash.traveally.viewmodel.state.HomeState

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onDialogDismiss: () -> Unit = viewModel::clearError,
    onLikeClick: (Place) -> Unit = viewModel::likePlace,
    onItemClick: (Place) -> Unit
) {
    var search by remember { mutableStateOf("") }
    val state: HomeState = viewModel.homeState

    if (state.isLoading) {
        LoaderDialog()
    }

    if (state.error != null) {
        FailureDialog("Something went wrong", onDialogDismiss = onDialogDismiss)
    }

    Column {
        SearchBar(searchText = search, onSearchTextChanged = { search = it }, modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(state.places) { place ->
                PlaceItem(place, onItemClick, onLikeClick)
            }
        }
    }
}
