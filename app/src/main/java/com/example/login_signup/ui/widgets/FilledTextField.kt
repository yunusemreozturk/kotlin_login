package com.example.login_signup.ui.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.login_signup.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilledTextField(title: Int, text: String, onValueChange: (text: String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = stringResource(title),
            style = Typography.bodyMedium.copy(fontWeight = FontWeight.Black)
        )
        Box(modifier = Modifier.height(10.dp))
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp),
            value = text,
            onValueChange = onValueChange,
            shape = CircleShape,
        )
    }
}