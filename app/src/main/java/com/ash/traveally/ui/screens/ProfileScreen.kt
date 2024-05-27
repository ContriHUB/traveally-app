package com.ash.traveally.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ash.traveally.models.User
import com.ash.traveally.models.userItem
import com.ash.traveally.ui.components.buttons.CustomButton
import com.ash.traveally.ui.theme.MontserratAlternates

@Composable
fun ProfileScreen(user: User = userItem) {
    Column (
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = ImageRequest
                .Builder(LocalContext.current)
                .data(user.photoUrl)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .clip(CircleShape)
                .border(4.dp, Color.Black, CircleShape)
        )
        CustomButton(text = "Change Picture", onClick = {})
        Spacer(modifier = Modifier.padding(6.dp))
        Text(
            text = "Name : " + user.name,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = MontserratAlternates
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Divider()
        Text(
            text = "Username : " + user.username,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = MontserratAlternates
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Divider()
        Text(
            text = "Phone Number : " + user.phoneNumber,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = MontserratAlternates
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Divider()
        Text(
            text = "Email : " + user.email,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = MontserratAlternates
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Divider()
        Text(
            text = "Location : " + user.city + ", " + user.country,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = MontserratAlternates
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Divider()
        Text(
            text = "Bio : " + user.bio,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = MontserratAlternates
            ),
            modifier = Modifier.padding(horizontal = 8.dp).align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Contact us : traveally-care@gmail.com" ,
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = MontserratAlternates
            ),
            modifier = Modifier.padding(8.dp)
        )
    }
}