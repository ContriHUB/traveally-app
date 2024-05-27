package com.ash.traveally.ui.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.ash.traveally.R
import com.ash.traveally.models.Place
import com.ash.traveally.models.placeItem
import com.ash.traveally.ui.components.buttons.BackButton
import com.ash.traveally.ui.components.buttons.FullWidthButton
import com.ash.traveally.ui.components.buttons.LikeButton
import com.ash.traveally.ui.theme.LightGreen
import com.ash.traveally.ui.theme.MontserratAlternates

@Composable
fun PlaceScreen(place: Place = placeItem) {
    Column (
        modifier = Modifier
            .background(color = Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Box (modifier = Modifier.background(color = Color.White)) {
            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(place.hotelPhoto)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
            )
            BackButton(modifier = Modifier.align(Alignment.TopStart).padding(start  = 8.dp, top = 8.dp))
            LikeButton(modifier = Modifier.align(Alignment.TopEnd).padding(end  = 8.dp, top = 8.dp))
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .padding(horizontal = 24.dp)
            ) {
                Column {
                    Text(
                        text = place.name,
                        style = TextStyle(
                            fontSize = 28.sp,
                            fontFamily = MontserratAlternates,
                            fontWeight = FontWeight.W600
                        ),
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(vertical = 6.dp)
                    )
                    Row (
                        modifier = Modifier
                            .padding(bottom = 6.dp)
                            .align(Alignment.CenterHorizontally)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.ic_location),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = place.city + ", " + place.country,
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = MontserratAlternates
                            )
                        )
                    }
                }
            }
        }
        Row (modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = null,
                modifier = Modifier.size(height = 32.dp, width = 32.dp)
            )
            Text(
                text = place.rating.toString() + " / 5.0",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = MontserratAlternates,
                    fontWeight = FontWeight.W400
                ),
                modifier = Modifier.padding(top = 5.dp, start = 4.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "$",
                style = TextStyle(
                    fontSize = 28.sp,
                    fontFamily = MontserratAlternates,
                    fontWeight = FontWeight.W500
                )
            )
            Text(
                text = place.price.toString() + " / day",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = MontserratAlternates,
                    fontWeight = FontWeight.W400
                ),
                modifier = Modifier.padding(top = 5.dp, start = 4.dp)
            )
        }
        Text(
            text = "Perks",
            style = TextStyle(
                fontSize = 28.sp,
                fontFamily = MontserratAlternates,
                fontWeight = FontWeight.W500
            ),
            color = Color.White,
            modifier = Modifier
                .background(
                    color = LightGreen,
                    shape = RoundedCornerShape(topEnd = 100.dp, bottomEnd = 100.dp)
                )
                .padding(start = 16.dp, end = 24.dp, top = 12.dp, bottom = 12.dp)
        )

        LazyRow(modifier = Modifier.padding(vertical = 12.dp)){
            if (place.hasWifi) {
                item {
                    PerkIcons(id = R.drawable.ic_wifi, text = "Wifi")
                }
            }
            if (place.hasFood) {
                item {
                    PerkIcons(id = R.drawable.ic_food, text = "Food")
                }
            }
            if (place.hasLaundry) {
                item {
                    PerkIcons(id = R.drawable.ic_laundry, text = "Laundry")
                }
            }
            if (place.hasSpa) {
                item {
                    PerkIcons(id = R.drawable.ic_spa, text = "Spa")
                }
            }
            if (place.hasTV) {
                item {
                    PerkIcons(id = R.drawable.ic_tv, text = "Digital TV")
                }
            }
            if (place.hasPool) {
                item {
                    PerkIcons(id = R.drawable.ic_pool, text = "Pool")
                }
            }
        }
        Text(
            text = "Summary",
            style = TextStyle(
                fontSize = 28.sp,
                fontFamily = MontserratAlternates,
                fontWeight = FontWeight.W500
            ),
            color = Color.White,
            modifier = Modifier
                .background(
                    color = LightGreen,
                    shape = RoundedCornerShape(topEnd = 100.dp, bottomEnd = 100.dp)
                )
                .padding(start = 16.dp, end = 24.dp, top = 12.dp, bottom = 12.dp)
        )
        Text(
            text = place.description,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = MontserratAlternates
            ),
            modifier = Modifier.padding(12.dp)
        )
        Box {
            Divider(color = Color.Black, thickness = 2.dp, modifier = Modifier.align(Alignment.Center))
            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(place.user.photoUrl)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Black, CircleShape)
                    .align(Alignment.Center)
            )
        }
        Text(
            text = place.user.name.split(" ")[0],
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = MontserratAlternates,
                fontWeight = FontWeight.W600
            ),
            modifier = Modifier
                .padding(vertical = 6.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = place.user.bio,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = MontserratAlternates
            ),
            modifier = Modifier.padding(12.dp)
        )
        FullWidthButton(text = "Book Package", modifier = Modifier.padding(12.dp)) {}
    }
}

@Composable
fun PerkIcons(
    @DrawableRes id: Int,
    text: String
) {
    Column (modifier = Modifier.padding(horizontal = 8.dp)) {
        Icon(
            painter = painterResource(id = id),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = text,
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = MontserratAlternates
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}