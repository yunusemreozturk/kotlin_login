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
import com.example.login_signup.ui.theme.MyApplicationTheme
import com.example.login_signup.ui.theme.Typography
import com.example.login_signup.ui.widgets.custom_textfields.CustomTextField
import com.example.login_signup.ui.widgets.LoginButton
import com.example.login_signup.ui.widgets.custom_textfields.CustomTextFieldForEmail
import com.example.login_signup.ui.widgets.custom_textfields.CustomTextFieldForPassword
import com.example.login_signup.viewmodel.SignUpViewModel

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = SignUpViewModel(),
) {
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
            text = viewModel.signUpFormState.fullName,
            onValueChange = {
                viewModel.onSignUpEvent(SignUpFormEvent.FullNameChanged(it))
            },
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            singleLine = true,
            isError = viewModel.signUpFormState.fullNameError != null,
            errorMessage = viewModel.signUpFormState.fullNameError,
        )
        Box(modifier = Modifier.height(20.dp))
        CustomTextFieldForEmail(
            text = viewModel.signUpFormState.email,
            onValueChanged = {
                viewModel.onSignUpEvent(SignUpFormEvent.EmailChanged(it))
            },
            isError = viewModel.signUpFormState.emailError != null,
            errorMessage = viewModel.signUpFormState.emailError
        )
        Box(modifier = Modifier.height(20.dp))
        CustomTextFieldForPassword(
            text = viewModel.signUpFormState.password,
            onValueChanged = {
                viewModel.onSignUpEvent(SignUpFormEvent.PasswordChanged(it))
            },
            visiblePasswordOnClick = {
                viewModel.onSignUpEvent(SignUpFormEvent.VisiblePassword(!(viewModel.signUpFormState.isVisiblePassword)))
            },
            isVisiblePassword = viewModel.signUpFormState.isVisiblePassword,
            isError = viewModel.signUpFormState.passwordError != null,
            errorMessage = viewModel.signUpFormState.passwordError,
        )
        Box(modifier = Modifier.height(20.dp))
        CustomTextField(
            placeholder = stringResource(id = R.string.phone_no),
            text = viewModel.signUpFormState.phoneNo ?: "",
            onValueChange = {
                viewModel.onSignUpEvent(SignUpFormEvent.PhoneNoChanged(it))
            },
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Next,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            singleLine = true,
            isError = viewModel.signUpFormState.phoneNoError != null,
            errorMessage = viewModel.signUpFormState.phoneNoError
        )
        Box(modifier = Modifier.height(40.dp))
        LoginButton(text = R.string.sign_up, onClick = {
            viewModel.onSignUpEvent(SignUpFormEvent.Submit)
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