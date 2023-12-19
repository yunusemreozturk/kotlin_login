package com.example.login_signup.ui.widgets.custom_textfields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.login_signup.R
import com.example.login_signup.util.UiText

@Composable
fun CustomTextFieldForEmail(
    text: String,
    onValueChanged: (String) -> Unit,
    isError: Boolean,
    errorMessage: UiText?
) {
    CustomTextField(
        placeholder = stringResource(id = R.string.email),
        text = text,
        onValueChange = onValueChanged,
        keyboardType = KeyboardType.Email,
        imeAction = ImeAction.Next,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        singleLine = true,
        isError = isError,
        errorMessage = errorMessage,
    )
}