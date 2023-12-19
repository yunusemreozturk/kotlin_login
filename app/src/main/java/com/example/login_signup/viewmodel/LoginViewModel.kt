package com.example.login_signup.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.login_signup.ui.screens.login.LoginFormEvent
import com.example.login_signup.ui.screens.login.LoginFormState
import com.example.login_signup.util.validations.EmailValidate
import com.example.login_signup.util.validations.PasswordValidate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : AuthViewModel() {
    var loginFormState by mutableStateOf(LoginFormState())
    private val emailValidate = EmailValidate()
    private val passwordValidate = PasswordValidate()

    private fun validateEmail(): Boolean {
        val emailResult = emailValidate.execute(loginFormState.email)
        loginFormState = loginFormState.copy(emailError = emailResult.errorMessage)
        return emailResult.successful
    }

    private fun validatePassword(): Boolean {
        val passwordResult = passwordValidate.execute(loginFormState.password)
        loginFormState = loginFormState.copy(passwordError = passwordResult.errorMessage)
        return passwordResult.successful
    }

    fun onLoginEvent(event: LoginFormEvent) {
        when (event) {
            is LoginFormEvent.EmailChanged -> {
                loginFormState = loginFormState.copy(email = event.email)
                validateEmail()
            }

            is LoginFormEvent.PasswordChanged -> {
                loginFormState = loginFormState.copy(password = event.password)
                validatePassword()
            }

            is LoginFormEvent.VisiblePassword -> {
                loginFormState = loginFormState.copy(isVisiblePassword = event.isVisiblePassword)
            }

            is LoginFormEvent.Submit -> {
                if (validateEmail() && validatePassword()) {
                    CoroutineScope(Dispatchers.Default).launch { login() }
                }
            }
        }
    }
}