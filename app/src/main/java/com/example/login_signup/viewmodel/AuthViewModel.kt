package com.example.login_signup.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
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

open class AuthViewModel : ViewModel() {
    val authService: FirebaseAuthService = FirebaseAuthService()
    var isBusy by mutableStateOf(false)

    private val _uiState = MutableStateFlow(UserModel())
    val uiState: StateFlow<UserModel> = _uiState.asStateFlow()

    suspend fun login() {
        isBusy = true
        val user =
            authService.signIn(uiState.value.email ?: "", uiState.value.password ?: "")

        if (user != null) {
            _uiState.value = UserModel(id = user.uid, email = user.email)
        }
        isBusy = false
    }


    suspend fun signUp() {
        isBusy = true
        val user =
            authService.createAccount(uiState.value.email ?: "", uiState.value.password ?: "")

        if (user != null) {
            _uiState.value = UserModel(id = user.uid, email = user.email)
        }
        isBusy = false
    }
}