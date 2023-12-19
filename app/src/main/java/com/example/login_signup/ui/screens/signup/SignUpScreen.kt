package com.example.login_signup.ui.screens.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login_signup.R
import com.example.login_signup.ui.screens.login.LoginFormEvent
import com.example.login_signup.ui.theme.MyApplicationTheme
import com.example.login_signup.ui.theme.Typography
import com.example.login_signup.ui.widgets.custom_textfields.CustomTextField
import com.example.login_signup.ui.widgets.custom_textfields.FilledTextField
import com.example.login_signup.ui.widgets.LoginButton
import com.example.login_signup.ui.widgets.custom_textfields.CustomTextFieldForEmail
import com.example.login_signup.ui.widgets.custom_textfields.CustomTextFieldForPassword
import com.example.login_signup.viewmodel.AuthViewModel

@Composable
fun SignUpScreen(
    authViewModel: AuthViewModel = AuthViewModel(),
) {
    val state = authViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.create_account),
            style = Typography.bodyMedium.copy(fontWeight = FontWeight.Black),
        )
        Box(modifier = Modifier.height(30.dp))
        CustomTextField(
            placeholder = stringResource(id = R.string.full_name),
            text = state.value.fullName ?: "",
            onValueChange = {
                authViewModel.onSignUpEvent(SignUpFormEvent.FullNameChanged(it))
            },
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            singleLine = true,
            isError = authViewModel.signUpFormState.fullNameError != null,
            errorMessage = authViewModel.signUpFormState.fullNameError
        )
        CustomTextField(
            placeholder = stringResource(id = R.string.full_name),
            text = authViewModel.signUpFormState.fullName,
            onValueChange = {
                authViewModel.onSignUpEvent(SignUpFormEvent.FullNameChanged(it))
            },
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            singleLine = true,
            isError = authViewModel.signUpFormState.fullNameError != null,
            errorMessage = authViewModel.signUpFormState.fullNameError,
        )
        Box(modifier = Modifier.height(20.dp))
        CustomTextFieldForEmail(
            text = authViewModel.signUpFormState.email,
            onValueChanged = {
                authViewModel.onSignUpEvent(SignUpFormEvent.EmailChanged(it))
            },
            isError = authViewModel.signUpFormState.emailError != null,
            errorMessage = authViewModel.signUpFormState.emailError
        )
        Box(modifier = Modifier.height(20.dp))
        CustomTextFieldForPassword(
            text = authViewModel.signUpFormState.password,
            onValueChanged = {
                authViewModel.onSignUpEvent(SignUpFormEvent.PasswordChanged(it))
            },
            visiblePasswordOnClick = {
                authViewModel.onSignUpEvent(SignUpFormEvent.VisiblePassword(!(authViewModel.signUpFormState.isVisiblePassword)))
            },
            isVisiblePassword = authViewModel.signUpFormState.isVisiblePassword,
            isError = authViewModel.signUpFormState.passwordError != null,
            errorMessage = authViewModel.signUpFormState.passwordError,
        )
        Box(modifier = Modifier.height(20.dp))
        CustomTextField(
            placeholder = stringResource(id = R.string.password),
            text = state.value.phoneNo ?: "",
            onValueChange = {
                authViewModel.onSignUpEvent(SignUpFormEvent.PhoneNoChanged(it))
            },
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            singleLine = true,
            isError = authViewModel.signUpFormState.phoneNoError != null,
            errorMessage = authViewModel.signUpFormState.phoneNoError
        )
        Box(modifier = Modifier.height(40.dp))
        LoginButton(text = R.string.sign_up, onClick = {
            authViewModel.onSignUpEvent(SignUpFormEvent.Submit)
        })
    }

}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun SignUpScreenPreviewLight() {
    MyApplicationTheme(darkTheme = false) {
        SignUpScreen()
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun SignUpScreenPreviewDark() {
    MyApplicationTheme(darkTheme = true) {
        SignUpScreen()
    }
}