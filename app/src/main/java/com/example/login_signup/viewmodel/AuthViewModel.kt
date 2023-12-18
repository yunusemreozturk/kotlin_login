package com.example.login_signup.viewmodel

import androidx.lifecycle.ViewModel
import com.example.login_signup.models.UserModel
import com.example.login_signup.service.FirebaseAuthService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel : ViewModel() {
    val firebaseAuthService: FirebaseAuthService = FirebaseAuthService()

    private val _uiState = MutableStateFlow(UserModel())
    val uiState: StateFlow<UserModel> = _uiState.asStateFlow()

    suspend fun signIn(email: String, password: String) {}

    suspend fun signUp(email: String, password: String) {}
}