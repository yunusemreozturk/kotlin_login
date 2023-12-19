package com.example.login_signup.ui.screens.signup

import com.example.login_signup.util.UiText

data class SignUpFormState(
    val email: String = "",
    val emailError: UiText? = null,
    val password: String = "",
    val passwordError: UiText? = null,
    val isVisiblePassword: Boolean = false,
    val phoneNo: String = "",
    val phoneNoError: UiText? = null,
    val fullName: String = "",
    val fullNameError: UiText? = null
)