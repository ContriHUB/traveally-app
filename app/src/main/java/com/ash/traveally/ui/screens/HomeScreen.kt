package com.ash.traveally.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ash.traveally.R
import com.ash.traveally.models.Place
import com.ash.traveally.ui.components.items.PlaceItem
import com.ash.traveally.ui.theme.MontserratAlternates

@Composable
fun HomeScreen() {
    Column {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(72.dp)
                    .padding(16.dp)
            )
            Text(
                text = "traveally",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontFamily = MontserratAlternates,
                    fontWeight = FontWeight.W500
                ),
                modifier = Modifier.padding(top = 16.dp)
            )
            Spacer(Modifier.weight(1f))
            IconButton(
                onClick = {  },
                modifier = Modifier.padding(top = 12.dp, end = 12.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                )
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(places) { place ->
                PlaceItem(place)
            }
        }
    }
}

val places = listOf(
    Place(
        name = "Eiffel Tower",
        city = "Paris",
        country = "France",
        rating = 4.8f,
        isFavourite = true,
        url = "https://unsplash.com/photos/UDyF0_Frxqs/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8M3x8ZWlmZmVsJTIwdG93ZXJ8ZW58MHx8fHwxNzE2MzUxMDE2fDA&force=true"
    ),
    Place(
        name = "Eiffel Tower",
        city = "Paris",
        country = "France",
        rating = 4.8f,
        isFavourite = true,
        url = "https://unsplash.com/photos/UDyF0_Frxqs/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8M3x8ZWlmZmVsJTIwdG93ZXJ8ZW58MHx8fHwxNzE2MzUxMDE2fDA&force=true"
    ),
    Place(
        name = "Eiffel Tower",
        city = "Paris",
        country = "France",
        rating = 4.8f,
        isFavourite = true,
        url = "https://unsplash.com/photos/UDyF0_Frxqs/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8M3x8ZWlmZmVsJTIwdG93ZXJ8ZW58MHx8fHwxNzE2MzUxMDE2fDA&force=true"
    ),
    Place(
        name = "Eiffel Tower",
        city = "Paris",
        country = "France",
        rating = 4.8f,
        isFavourite = true,
        url = "https://unsplash.com/photos/UDyF0_Frxqs/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8M3x8ZWlmZmVsJTIwdG93ZXJ8ZW58MHx8fHwxNzE2MzUxMDE2fDA&force=true"
    ),
    Place(
        name = "Eiffel Tower",
        city = "Paris",
        country = "France",
        rating = 4.8f,
        isFavourite = true,
        url = "https://unsplash.com/photos/UDyF0_Frxqs/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8M3x8ZWlmZmVsJTIwdG93ZXJ8ZW58MHx8fHwxNzE2MzUxMDE2fDA&force=true"
    ),
    Place(
        name = "Eiffel Tower",
        city = "Paris",
        country = "France",
        rating = 4.8f,
        isFavourite = true,
        url = "https://unsplash.com/photos/UDyF0_Frxqs/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8M3x8ZWlmZmVsJTIwdG93ZXJ8ZW58MHx8fHwxNzE2MzUxMDE2fDA&force=true"
    ),
    Place(
        name = "Eiffel Tower",
        city = "Paris",
        country = "France",
        rating = 4.8f,
        isFavourite = true,
        url = "https://unsplash.com/photos/UDyF0_Frxqs/download?ixid=M3wxMjA3fDB8MXxzZWFyY2h8M3x8ZWlmZmVsJTIwdG93ZXJ8ZW58MHx8fHwxNzE2MzUxMDE2fDA&force=true"
    )
)