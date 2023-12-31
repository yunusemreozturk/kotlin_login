package com.example.login_signup.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login_signup.ui.theme.MyApplicationTheme

@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            color = MaterialTheme.colorScheme.secondary,
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenLight() {
    MyApplicationTheme(darkTheme = false) {
        SplashScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenDark() {
    MyApplicationTheme(darkTheme = true) {
        SplashScreen()
    }
}