package com.ash.traveally.ui.components.items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.ash.traveally.R
import com.ash.traveally.models.Place
import com.ash.traveally.ui.theme.MontserratAlternates
import kotlin.math.round

@Composable
fun PlaceItem(
    place: Place
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(place.url)
                    .size(Size.ORIGINAL)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
            )
            IconButton(
                onClick = {  },
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = 10.dp, top = 8.dp)
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_favourite_outline), contentDescription = null)
            }
        }
        Text(
            text = place.name,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = MontserratAlternates,
                fontWeight = FontWeight.W500),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Row(
            modifier = Modifier.padding(start = 4.dp, bottom = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = null,
                modifier = Modifier.size(height = 20.dp, width = 20.dp)
            )
            Text(
                text = place.city + ", " + place.country,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = MontserratAlternates
                ),
                modifier = Modifier.padding(top = 1.dp)
            )
            Spacer(Modifier.weight(1f))
            Image(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = null,
                modifier = Modifier.size(height = 20.dp, width = 20.dp)
            )
            Text(
                text = place.rating.toString(),
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = MontserratAlternates
                ),
                modifier = Modifier.padding(top = 1.dp, start = 2.dp, end = 8.dp)
            )
        }
    }
}