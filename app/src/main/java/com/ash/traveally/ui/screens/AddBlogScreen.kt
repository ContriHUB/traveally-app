package com.ash.traveally.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ash.traveally.R
import com.ash.traveally.ui.components.etc.TopAppBar
import com.ash.traveally.ui.theme.LightGreen
import com.ash.traveally.ui.theme.MontserratAlternates

@Composable
fun AddBlogScreen() {
    var title by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var introduction by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    Column (
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(12.dp)
    ) {
        TopAppBar()
        OutlinedTextField(
            value = title,
            label = { Text(text = "Title", fontSize = 14.sp, fontFamily = MontserratAlternates, fontWeight = FontWeight.W500) },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
                .testTag("Title"),
            onValueChange = { title = it },
            textStyle = TextStyle(fontSize = 15.sp, fontFamily = MontserratAlternates, color = Color.Black),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = LightGreen, focusedLabelColor = LightGreen)
        )
        Row (horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedTextField(
                value = city,
                label = { Text(text = "City", fontSize = 14.sp, fontFamily = MontserratAlternates, fontWeight = FontWeight.W500) },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .testTag("City"),
                onValueChange = { city = it },
                textStyle = TextStyle(fontSize = 15.sp, fontFamily = MontserratAlternates, color = Color.Black),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = LightGreen, focusedLabelColor = LightGreen)
            )
            OutlinedTextField(
                value = country,
                label = { Text(text = "Country", fontSize = 14.sp, fontFamily = MontserratAlternates, fontWeight = FontWeight.W500) },
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("Country"),
                onValueChange = { country = it },
                textStyle = TextStyle(fontSize = 15.sp, fontFamily = MontserratAlternates, color = Color.Black),
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = LightGreen, focusedLabelColor = LightGreen)
            )
        }
        OutlinedTextField(
            value = introduction,
            label = { Text(text = "Introduction", fontSize = 14.sp, fontFamily = MontserratAlternates, fontWeight = FontWeight.W500) },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .testTag("Introduction"),
            onValueChange = { introduction = it },
            textStyle = TextStyle(fontSize = 15.sp, fontFamily = MontserratAlternates, color = Color.Black),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = LightGreen, focusedLabelColor = LightGreen)
        )
        OutlinedTextField(
            value = description,
            label = { Text(text = "Description", fontSize = 14.sp, fontFamily = MontserratAlternates, fontWeight = FontWeight.W500) },
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .testTag("Description"),
            onValueChange = { description = it },
            textStyle = TextStyle(fontSize = 15.sp, fontFamily = MontserratAlternates, color = Color.Black),
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = LightGreen, focusedLabelColor = LightGreen)
        )
    }
    Column (
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ) {
        FloatingActionButton(
            onClick = { }
        ) {
            Icon(painterResource(id = R.drawable.ic_attach),"")
        }
        Spacer(modifier = Modifier.padding(8.dp))
        FloatingActionButton(
            onClick = {}
        ) {
            Icon(painterResource(id = R.drawable.ic_send),"")
        }
    }
}