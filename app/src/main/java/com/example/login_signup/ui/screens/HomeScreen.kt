package com.example.login_signup.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.example.login_signup.R
import com.example.login_signup.ui.theme.MyApplicationTheme
import com.example.login_signup.ui.widgets.CustomButton
import com.example.login_signup.viewmodel.AuthViewModel

@Composable
fun HomeScreen(authViewModel: AuthViewModel = AuthViewModel()) {
    var user = authViewModel.uiState.collectAsState()

    Column() {
        Text(text = user.value.id ?: "")
        CustomButton(text = R.string.test, onClick = { authViewModel.signOut() })
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenPreviewLight() {
    MyApplicationTheme(darkTheme = false) {
        HomeScreen()
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeScreenPreviewDark() {
    MyApplicationTheme(darkTheme = true) {
        HomeScreen()
    }
}



