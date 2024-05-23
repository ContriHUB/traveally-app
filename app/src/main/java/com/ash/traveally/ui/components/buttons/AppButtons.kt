package com.ash.traveally.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ash.traveally.ui.theme.LightGreen
import com.ash.traveally.ui.theme.MontserratAlternates

@Composable
fun FullWidthButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = LightGreen),
        shape = RoundedCornerShape(5.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(5.dp))
    ) {
        Text(
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = MontserratAlternates,
                fontWeight = FontWeight.W500
            ),
            color = Color.White,
            text = text
        )
    }
}