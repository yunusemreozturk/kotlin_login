package com.example.login_signup.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.login_signup.R
import com.example.login_signup.ui.theme.MyApplicationTheme
import com.example.login_signup.ui.widgets.LoginButton
import com.example.login_signup.ui.widgets.SocialSignButton

@Composable
fun WelcomeScreen(loginButtonOnClick: () -> Unit = {}, signUpOnClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            painter = painterResource(id = R.drawable.reshot_illustration_website_development),
            contentScale = ContentScale.Crop,
            contentDescription = null
        )
        Box(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.hello_welcome),
            style = MaterialTheme.typography.bodyLarge,
        )
        Box(modifier = Modifier.height(20.dp))
        Text(
            modifier = Modifier.fillMaxWidth(0.8f),
            text = stringResource(id = R.string.welcome_code_champ),
            style = MaterialTheme.typography.bodySmall.copy(
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
            ),
        )
        Box(modifier = Modifier.height(40.dp))
        LoginButton(text = R.string.login, onClick = loginButtonOnClick)
        Box(modifier = Modifier.height(10.dp))
        LoginButton(text = R.string.sign_up, onClick = signUpOnClick)
        Box(modifier = Modifier.height(80.dp))
        Text(
            text = stringResource(id = R.string.or_via_social_media),
            style = MaterialTheme.typography.labelSmall,
        )
        Row {
            SocialSignButton(icon = R.drawable.facebook_icon)
            SocialSignButton(icon = R.drawable.google_icon)
            SocialSignButton(icon = R.drawable.linkedin_icon)
        }
    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun WelcomeScreenPreviewLight() {
    MyApplicationTheme(darkTheme = false) {
        WelcomeScreen()
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun WelcomeScreenPreviewDark() {
    MyApplicationTheme(darkTheme = true) {
        WelcomeScreen()
    }
}