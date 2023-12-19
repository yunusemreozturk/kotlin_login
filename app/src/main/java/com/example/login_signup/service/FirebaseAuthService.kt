package com.example.login_signup.service

import com.example.login_signup.util.CS
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import kotlinx.coroutines.tasks.await

class FirebaseAuthService {
    private var auth: FirebaseAuth = Firebase.auth

    fun getCurrentUser(): FirebaseUser? {
        val currentUser = auth.currentUser
        CS.d("$currentUser")

        return currentUser
    }

    suspend fun createAccount(email: String, password: String): FirebaseUser? {
        val authResult = auth.createUserWithEmailAndPassword(email, password).await()

        return authResult.user
    }

    suspend fun signIn(email: String, password: String): FirebaseUser? {
        val authResult = auth.signInWithEmailAndPassword(email, password).await()

        return authResult.user
    }

    suspend fun sendEmailVerification(): Boolean {
        return try {
            val user = getCurrentUser()

            user?.sendEmailVerification()?.await()

            true
        } catch (e: Exception) {
            CS.e("FirebaseAuthService: sendEmailVerification $e")
            false
        }
    }

    fun signOut() {
        auth.signOut()
    }
}