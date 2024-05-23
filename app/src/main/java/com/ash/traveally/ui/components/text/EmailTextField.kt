package com.ash.traveally.ui.components.text

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ash.traveally.R

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    isError: Boolean = false,
    onValueChange: (String) -> Unit
) {
    AppTextField(
        value = value,
        label = "Email",
        onValueChange = onValueChange,
        modifier = modifier,
        leadingIcon = { Icon(Icons.Outlined.Email, "Email") },
        isError = isError,
        helperText = stringResource(R.string.message_field_email_invalid)
    )
}