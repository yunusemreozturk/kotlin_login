package com.example.login_signup.ui.screens.login

import com.example.login_signup.util.UiText

data class LoginFormState(
    val email: String = "",
    val emailError: UiText? = null,
    val password: String = "",
    val passwordError: UiText? = null,
    val isVisiblePassword: Boolean = false
)