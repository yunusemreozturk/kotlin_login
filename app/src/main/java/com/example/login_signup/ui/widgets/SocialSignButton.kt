package com.example.login_signup.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SocialSignButton(icon: Int) {
    Image(
        modifier = Modifier
            .width(30.dp)
            .height(30.dp)
            .padding(5.dp),
        painter = painterResource(id = icon),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}