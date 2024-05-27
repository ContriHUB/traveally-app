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
import com.ash.traveally.models.Place
import com.ash.traveally.models.placeItem
import com.ash.traveally.ui.components.items.PlaceItem
import com.ash.traveally.ui.components.text.SearchBar

@Composable
fun HomeScreen(onItemClick: (Place) -> Unit) {
    var search by remember { mutableStateOf("") }
    Column {
        SearchBar(searchText = search, onSearchTextChanged = { search = it }, modifier = Modifier.padding(horizontal = 24.dp, vertical = 12.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(places) { place ->
                PlaceItem(place, onItemClick)
            }
        }
    }
}

val places = listOf(placeItem, placeItem, placeItem, placeItem, placeItem, placeItem, placeItem, placeItem)