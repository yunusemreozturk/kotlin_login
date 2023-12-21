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
    private val _authService: FirebaseAuthService = FirebaseAuthService()
    var isBusy by mutableStateOf(false)

    private val _uiState = MutableStateFlow(UserModel())
    val uiState: StateFlow<UserModel> = _uiState.asStateFlow()

    init {
        isBusy = true
        val user = _authService.getCurrentUser();

        if (user != null) {
            _uiState.value = UserModel(id = user.uid, email = user.email)
        }
        isBusy = false
    }

    suspend fun login(email: String, password: String) {
        isBusy = true
        val user =
            _authService.signIn(email, password)

        if (user != null) {
            _uiState.value = UserModel(id = user.uid, email = user.email)
        }
        isBusy = false
    }


    suspend fun signUp(email: String, password: String) {
        isBusy = true
        val user =
            _authService.createAccount(email, password)

        if (user != null) {
            _uiState.value = UserModel(id = user.uid, email = user.email)
        }
        isBusy = false
    }

    fun signOut() {
        isBusy = true

        _authService.signOut()

        _uiState.value = UserModel()

        isBusy = false
    }
}