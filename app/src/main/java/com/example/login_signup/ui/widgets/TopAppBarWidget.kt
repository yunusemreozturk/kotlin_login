package com.example.login_signup.ui.widgets

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.login_signup.AppScreen
import com.example.login_signup.R
import com.example.login_signup.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarWidget(currentScreen: AppScreen, canNavigateBack: Boolean = false, navigateUp: () -> Unit = {}) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title), style = Typography.bodyMedium) },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}