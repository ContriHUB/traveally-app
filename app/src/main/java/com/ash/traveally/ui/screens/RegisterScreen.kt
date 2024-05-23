package com.ash.traveally.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ash.traveally.R
import com.ash.traveally.ui.components.buttons.FullWidthButton
import com.ash.traveally.ui.components.dialog.FailureDialog
import com.ash.traveally.ui.components.dialog.LoaderDialog
import com.ash.traveally.ui.components.text.EmailTextField
import com.ash.traveally.ui.components.text.PasswordTextField
import com.ash.traveally.ui.components.text.PhoneNumberTextField
import com.ash.traveally.ui.components.text.UsernameTextField
import com.ash.traveally.ui.theme.LightGreen
import com.ash.traveally.ui.theme.MontserratAlternates
import com.ash.traveally.viewmodel.RegisterViewModel
import com.ash.traveally.viewmodel.state.RegisterState

@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = hiltViewModel(),
    onNavigateToLogin: () -> Unit
) {
    var state: RegisterState = viewModel.registerState
    val context = LocalContext.current

    SignUpContent(
        isLoading = state.isLoading,
        email = state.email,
        username = state.username,
        phoneNumber = state.phoneNumber,
        password = state.password,
        confirmPassword = state.confirmPassword,
        isValidEmail = state.isValidEmail ?: true,
        isValidUsername = state.isValidUsername ?: true,
        isValidPhoneNumber = state.isValidPhoneNumber ?: true,
        isValidPassword = state.isValidPassword ?: true,
        isValidConfirmPassword = state.isValidConfirmPassword ?: true,
        onEmailChange = viewModel:: setEmail,
        onUsernameChange = viewModel::setUsername,
        onPhoneNumberChange = viewModel::setPhoneNumber,
        onPasswordChange = viewModel::setPassword,
        onConfirmPasswordChange = viewModel::setConfirmPassword,
        onDialogDismiss = viewModel::clearError,
        error = state.error,
        onRegisterClick = viewModel::registerUser,
        onSigninTextClick = onNavigateToLogin
    )

    LaunchedEffect(state.isRegisteredIn) {
        if (state.isRegisteredIn) {
            Toast.makeText(context, state.message!!.message, Toast.LENGTH_LONG).show()
            onNavigateToLogin()
        }
    }
}

@Composable
fun SignUpContent(
    isLoading: Boolean,
    email: String,
    username: String,
    phoneNumber: String,
    password: String,
    confirmPassword: String,
    isValidEmail: Boolean,
    isValidUsername: Boolean,
    isValidPhoneNumber: Boolean,
    isValidPassword: Boolean,
    isValidConfirmPassword: Boolean,
    onEmailChange: (String) -> Unit,
    onUsernameChange: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onDialogDismiss: () -> Unit,
    error: String?,
    onRegisterClick: () -> Unit,
    onSigninTextClick: () -> Unit
) {
    if (isLoading) {
        LoaderDialog()
    }

    if (error != null) {
        FailureDialog(error, onDialogDismiss = onDialogDismiss)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Create\nAccount",
            style = TextStyle(
                fontSize = 30.sp,
                fontFamily = MontserratAlternates,
                fontWeight = FontWeight.W500
            ),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 30.dp)
        )

        SignUpForm(
            email = email,
            username = username,
            phoneNumber = phoneNumber,
            password = password,
            confirmPassword = confirmPassword,
            onEmailChange = onEmailChange,
            onUsernameChange = onUsernameChange,
            onPhoneNumberChange = onPhoneNumberChange,
            onPasswordChange = onPasswordChange,
            onConfirmPasswordChange = onConfirmPasswordChange,
            isValidEmail = isValidEmail,
            isValidUsername = isValidUsername,
            isValidPhoneNumber = isValidPhoneNumber,
            isValidPassword = isValidPassword,
            isValidConfirmPassword = isValidConfirmPassword,
            onRegisterClick = onRegisterClick
        )

        LoginLink(Modifier.align(Alignment.CenterHorizontally), onSigninTextClick = onSigninTextClick)
    }
}

@Composable
private fun SignUpForm(
    email: String,
    username: String,
    phoneNumber: String,
    password: String,
    confirmPassword: String,
    isValidEmail: Boolean,
    isValidUsername: Boolean,
    isValidPhoneNumber: Boolean,
    isValidPassword: Boolean,
    isValidConfirmPassword: Boolean,
    onEmailChange: (String) -> Unit,
    onUsernameChange: (String) -> Unit,
    onPhoneNumberChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onRegisterClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(
            start = 16.dp,
            top = 32.dp,
            end = 16.dp,
            bottom = 16.dp
        )
    ) {
        EmailTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background),
            value = email,
            onValueChange = onEmailChange,
            isError = !isValidEmail
        )

        UsernameTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background),
            value = username,
            onValueChange = onUsernameChange,
            isError = !isValidUsername
        )

        PhoneNumberTextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background),
            value = phoneNumber,
            onValueChange = onPhoneNumberChange,
            isError = !isValidPhoneNumber
        )

        PasswordTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .background(MaterialTheme.colorScheme.background),
            helperText = stringResource(R.string.message_field_password_invalid),
            value = password,
            onValueChange = onPasswordChange,
            isError = !isValidPassword
        )

        PasswordTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .background(MaterialTheme.colorScheme.background),
            label = "Confirm Password",
            helperText = stringResource(R.string.message_field_confirm_password_invalid),
            value = confirmPassword,
            onValueChange = onConfirmPasswordChange,
            isError = !isValidConfirmPassword
        )

        FullWidthButton(
            text = "Register",
            onClick = onRegisterClick,
            modifier = Modifier.padding(top = 32.dp)
        )
    }
}

@Composable
private fun LoginLink(modifier: Modifier, onSigninTextClick: () -> Unit) {
    Text(
        text = buildAnnotatedString {
            append("Already have an account? Login")
            addStyle(SpanStyle(color = LightGreen), 24, this.length)
        },
        style = TextStyle(
            fontSize = 15.sp,
            fontFamily = MontserratAlternates,
            fontWeight = FontWeight.W500
        ),
        modifier = modifier
            .padding(vertical = 24.dp, horizontal = 16.dp)
            .clickable(onClick = onSigninTextClick)
    )
}