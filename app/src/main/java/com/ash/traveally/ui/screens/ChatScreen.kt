package com.ash.traveally.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ash.traveally.models.messageItem1
import com.ash.traveally.models.messageItem2
import com.ash.traveally.models.userItem
import com.ash.traveally.ui.components.buttons.BackButton
import com.ash.traveally.ui.components.buttons.CallButton
import com.ash.traveally.ui.components.text.MessageTextField
import com.ash.traveally.ui.theme.LightGreen
import com.ash.traveally.ui.theme.MontserratAlternates

@Composable
fun ChatScreen() {
    Column {
        Card (
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(modifier = Modifier.padding(vertical = 8.dp)) {
                BackButton(modifier = Modifier.padding(8.dp))
                AsyncImage(
                    model = ImageRequest
                        .Builder(LocalContext.current)
                        .data(userItem.photoUrl)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Black, CircleShape)
                )
                Text(
                    text = userItem.name,
                    style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = MontserratAlternates,
                        fontWeight = FontWeight.W600
                    ),
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                CallButton(modifier = Modifier.padding(8.dp))
            }
        }
        LazyColumn(
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(messages) { message ->
                if (message.userId == 0L) {
                    // left side
                    Text(
                        text = message.message,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = MontserratAlternates,
                            fontWeight = FontWeight.W500
                        ),
                        modifier = Modifier
                            .background(
                                color = LightGreen,
                                shape = RoundedCornerShape(topStart = 8.dp, bottomEnd = 8.dp)
                            )
                            .padding(12.dp)
                    )
                } else {
                    Row {
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = message.message,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = MontserratAlternates,
                                fontWeight = FontWeight.W500
                            ),
                            modifier = Modifier
                                .background(
                                    color = LightGreen,
                                    shape = RoundedCornerShape(topEnd = 8.dp, bottomStart = 8.dp)
                                )
                                .padding(12.dp)
                        )
                    }
                }
            }
        }
        MessageTextField(modifier = Modifier.padding(top = 12.dp, bottom = 12.dp, start = 12.dp, end = 8.dp))
    }
}

val messages = listOf(messageItem1, messageItem1, messageItem2, messageItem1, messageItem2, messageItem1, messageItem2,messageItem1, messageItem1, messageItem2, messageItem1, messageItem2, messageItem1, messageItem2)
