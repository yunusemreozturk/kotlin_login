package com.example.login_signup.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login_signup.R
import com.example.login_signup.ui.theme.MyApplicationTheme
import com.example.login_signup.ui.theme.Primary
import com.example.login_signup.ui.theme.Typography
import com.example.login_signup.ui.widgets.custom_textfields.CustomTextFieldForEmail
import com.example.login_signup.ui.widgets.LoginButton
import com.example.login_signup.ui.widgets.custom_textfields.CustomTextFieldForPassword
import com.example.login_signup.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    authViewModel: AuthViewModel = AuthViewModel(),
    signUpOnClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = stringResource(id = R.string.welcome_back),
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Black),
        )
        Box(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.login_continue),
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
            ),
        )
        Box(modifier = Modifier.height(40.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomTextFieldForEmail(
                text = authViewModel.loginFormState.email,
                onValueChanged = { authViewModel.onLoginEvent(LoginFormEvent.EmailChanged(it)) },
                isError = authViewModel.loginFormState.emailError != null,
                errorMessage = authViewModel.loginFormState.emailError
            )
            Box(modifier = Modifier.height(30.dp))
            CustomTextFieldForPassword(
                text = authViewModel.loginFormState.password,
                onValueChanged = {
                    authViewModel.onLoginEvent(LoginFormEvent.PasswordChanged(it))
                },
                visiblePasswordOnClick = {
                    authViewModel.onLoginEvent(LoginFormEvent.VisiblePassword(!(authViewModel.loginFormState.isVisiblePassword)))
                },
                isVisiblePassword = authViewModel.loginFormState.isVisiblePassword,
                isError = authViewModel.loginFormState.passwordError != null,
                errorMessage = authViewModel.loginFormState.passwordError,
            )
            Box(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = false, onCheckedChange = {})
                    Text(
                        text = stringResource(id = R.string.remember_me),
                        style = Typography.labelLarge
                    )
                }
                Text(
                    text = stringResource(id = R.string.forget_password),
                    style = Typography.labelLarge
                )
            }
            Box(modifier = Modifier.height(20.dp))
            LoginButton(text = R.string.login, onClick = {
                authViewModel.onLoginEvent(LoginFormEvent.Submit)
            })
            Box(modifier = Modifier.height(30.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = stringResource(id = R.string.dont_have_account),
                    style = Typography.labelLarge
                )
                Box(modifier = Modifier.width(5.dp))
                ClickableText(
                    text = AnnotatedString(stringResource(id = R.string.sign_up)),
                    onClick = { signUpOnClick() },
                    style = Typography.labelLarge.copy(color = Primary),
                )
            }
        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreviewLight() {
    MyApplicationTheme(darkTheme = false) {
        LoginScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreviewDark() {
    MyApplicationTheme(darkTheme = true) {
        LoginScreen()
    }
}

