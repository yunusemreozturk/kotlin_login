package com.example.login_signup.ui.screens.login

import androidx.navigation.NavHostController

sealed class LoginFormEvent {
    data class EmailChanged(val email: String) : LoginFormEvent()
    data class PasswordChanged(val password: String) : LoginFormEvent()
    data class VisiblePassword(val isVisiblePassword: Boolean) : LoginFormEvent()
    object Submit : LoginFormEvent()
}