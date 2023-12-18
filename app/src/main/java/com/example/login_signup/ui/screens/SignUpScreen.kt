package com.example.login_signup.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login_signup.R
import com.example.login_signup.models.UserModel
import com.example.login_signup.ui.theme.MyApplicationTheme
import com.example.login_signup.ui.theme.Typography
import com.example.login_signup.ui.widgets.FilledTextField
import com.example.login_signup.ui.widgets.LoginButton

@Composable
fun SignUpScreen(signUpOnClick: () -> Unit = {}, userModel: UserModel = UserModel()) {
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
        FilledTextField(
            title = R.string.full_name,
            text = userModel.fullName ?: "",
            onValueChange = { userModel.fullName = it },
        )
        Box(modifier = Modifier.height(20.dp))
        FilledTextField(
            title = R.string.email,
            text = userModel.email ?: "",
            onValueChange = { userModel.email = it },
        )
        Box(modifier = Modifier.height(20.dp))
        FilledTextField(
            title = R.string.password,
            text = userModel.password ?: "",
            onValueChange = { userModel.password = it },
        )
        Box(modifier = Modifier.height(20.dp))
        FilledTextField(
            title = R.string.phone_no,
            text = userModel.phoneNo ?: "",
            onValueChange = { userModel.phoneNo = it },
        )
        Box(modifier = Modifier.height(40.dp))
        LoginButton(text = R.string.sign_up, onClick = signUpOnClick)
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