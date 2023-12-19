package com.example.login_signup.viewmodel

import androidx.lifecycle.ViewModel
import com.example.login_signup.models.UserModel
import com.example.login_signup.service.FirebaseAuthService
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel : ViewModel() {
    val authService: FirebaseAuthService = FirebaseAuthService()

    private val _uiState = MutableStateFlow(UserModel())
    val uiState: StateFlow<UserModel> = _uiState.asStateFlow()

    suspend fun signIn(email: String, password: String): FirebaseUser? {
        return authService.signIn(email, password)
    }

    suspend fun signUp(email: String, password: String): FirebaseUser? {
        return authService.createAccount(email, password)
    }
}