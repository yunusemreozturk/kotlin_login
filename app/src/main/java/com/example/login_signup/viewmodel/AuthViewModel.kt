package com.example.login_signup.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.login_signup.AppScreen
import com.example.login_signup.models.UserModel
import com.example.login_signup.service.FirebaseAuthService
import com.example.login_signup.ui.screens.login.LoginFormEvent
import com.example.login_signup.ui.screens.login.LoginFormState
import com.example.login_signup.ui.screens.signup.SignUpFormEvent
import com.example.login_signup.ui.screens.signup.SignUpFormState
import com.example.login_signup.util.validations.EmailValidate
import com.example.login_signup.util.validations.NameValidate
import com.example.login_signup.util.validations.PasswordValidate
import com.example.login_signup.util.validations.PhoneNoValidate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    val authService: FirebaseAuthService = FirebaseAuthService()
    var _isBusy by mutableStateOf(false)
    private val _uiState = MutableStateFlow(UserModel())
    val uiState: StateFlow<UserModel> = _uiState.asStateFlow()

    private val emailValidate = EmailValidate()
    private val passwordValidate = PasswordValidate()
    private val nameValidate = NameValidate()
    private val phoneNoValidate = PhoneNoValidate()

    var loginFormState by mutableStateOf(LoginFormState())
    var signUpFormState by mutableStateOf(SignUpFormState())

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

    fun onSignUpEvent(event: SignUpFormEvent) {
        when (event) {
            is SignUpFormEvent.EmailChanged -> {
                signUpFormState = signUpFormState.copy(email = event.email)
                validateEmail()
            }

            is SignUpFormEvent.PasswordChanged -> {
                signUpFormState = signUpFormState.copy(password = event.password)
                validatePassword()
            }

            is SignUpFormEvent.VisiblePassword -> {
                signUpFormState = signUpFormState.copy(isVisiblePassword = event.isVisiblePassword)
            }

            is SignUpFormEvent.FullNameChanged -> {
                signUpFormState = signUpFormState.copy(fullName = event.fullName)
            }

            is SignUpFormEvent.PhoneNoChanged -> {
                signUpFormState = signUpFormState.copy(phoneNo = event.phoneNo)
            }

            is SignUpFormEvent.Submit -> {
                if (validateEmail() && validatePassword() && validateName() && validatePhoneNo()) {
                    CoroutineScope(Dispatchers.Default).launch { signUp() }
                }
            }
        }
    }

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

    private fun validateName(): Boolean {
        val passwordResult = nameValidate.execute(loginFormState.password)
        loginFormState = loginFormState.copy(passwordError = passwordResult.errorMessage)
        return passwordResult.successful
    }

    private fun validatePhoneNo(): Boolean {
        val passwordResult = phoneNoValidate.execute(loginFormState.password)
        loginFormState = loginFormState.copy(passwordError = passwordResult.errorMessage)
        return passwordResult.successful
    }

    suspend fun login() {
        _isBusy = true
        val user =
            authService.signIn(uiState.value.email ?: "", uiState.value.password ?: "")

        if (user != null) {

        }
        _isBusy = false
    }


    suspend fun signUp() {
        _isBusy = true
        val user =
            authService.createAccount(uiState.value.email ?: "", uiState.value.password ?: "")

        if (user != null) {

        }
        _isBusy = false
    }
}