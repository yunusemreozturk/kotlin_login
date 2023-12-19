package com.example.login_signup.ui.screens.signup

import androidx.navigation.NavHostController
import com.example.login_signup.ui.screens.login.LoginFormEvent

sealed class SignUpFormEvent {
    data class EmailChanged(val email: String) : SignUpFormEvent()
    data class PasswordChanged(val password: String) : SignUpFormEvent()
    data class VisiblePassword(val isVisiblePassword: Boolean) : SignUpFormEvent()
    data class PhoneNoChanged(val phoneNo: String) : SignUpFormEvent()
    data class FullNameChanged(val fullName: String) : SignUpFormEvent()
    object Submit : SignUpFormEvent()
}