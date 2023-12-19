package com.example.login_signup.ui.widgets.custom_textfields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalMinimumTouchTargetEnforcement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.login_signup.R
import com.example.login_signup.util.UiText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextFieldForPassword(
    text: String,
    onValueChanged: (String) -> Unit,
    visiblePasswordOnClick: () -> Unit,
    isVisiblePassword: Boolean,
    isError: Boolean,
    errorMessage: UiText?
) {
    CustomTextField(
        placeholder = stringResource(id = R.string.password),
        text = text,
        onValueChange = onValueChanged,
        keyboardType = KeyboardType.Password,
        ImeAction.Done,
        trailingIcon = {
            CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
                IconButton(
                    onClick = visiblePasswordOnClick
                ) {
                    Icon(
                        painter = if (isVisiblePassword) painterResource(
                            id = R.drawable.ic_visible
                        ) else painterResource(
                            id = R.drawable.ic_invisible
                        ),
                        contentDescription = "Visible",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        },
        isVisible = isVisiblePassword,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        singleLine = true,
        isError = isError,
        errorMessage = errorMessage
    )
}