package com.ash.traveally.ui.screens

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.ash.traveally.models.Blog
import com.ash.traveally.models.blogItem
import com.ash.traveally.ui.components.buttons.BackButton
import com.ash.traveally.ui.components.buttons.SaveButton
import com.ash.traveally.ui.theme.LightGreen
import com.ash.traveally.ui.theme.MontserratAlternates
import kotlin.time.Duration.Companion.days

@Composable
fun BlogScreen(blog: Blog = blogItem) {
    Column (
        modifier = Modifier
            .background(color = Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Box (modifier = Modifier.background(color = Color.White)) {
            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(blog.placePhoto)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
            )
            BackButton(modifier = Modifier.align(Alignment.TopStart).padding(start  = 8.dp, top = 8.dp))
            SaveButton(modifier = Modifier.align(Alignment.TopEnd).padding(end  = 8.dp, top = 8.dp))
        }
        Row(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 12.dp)
        ) {
            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(blog.user.photoUrl)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Black, CircleShape)
            )
            Text(
                text = blog.user.name,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = MontserratAlternates
                ),
                modifier = Modifier.padding(top = 8.dp, start = 8.dp)
            )
        }
        Row(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = null,
                modifier = Modifier.size(28.dp)
            )
            Text(
                text = blog.city + ", " + blog.country,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = MontserratAlternates
                ),
                modifier = Modifier.padding(top = 4.dp, start = 4.dp)
            )
        }
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_date),
                contentDescription = null,
                modifier = Modifier.size(28.dp)
            )
            Text(
                text = blog.time.days.toString() + " days ago",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = MontserratAlternates
                ),
                modifier = Modifier.padding(top = 4.dp, start = 4.dp)
            )
        }
        Text(
            text = blog.title,
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = MontserratAlternates,
                fontWeight = FontWeight.W600
            ),
            modifier = Modifier.padding(top = 4.dp, bottom = 12.dp, start = 12.dp)
        )
        Text(
            text = "Introduction",
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
            text = blog.introduction,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = MontserratAlternates
            ),
            modifier = Modifier.padding(12.dp)
        )
        Text(
            text = "Content",
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
            text = blog.description,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = MontserratAlternates
            ),
            modifier = Modifier.padding(12.dp)
        )
    }
}