package com.example.login_signup.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.login_signup.ui.screens.signup.SignUpFormEvent
import com.example.login_signup.ui.screens.signup.SignUpFormState
import com.example.login_signup.util.validations.EmailValidate
import com.example.login_signup.util.validations.NameValidate
import com.example.login_signup.util.validations.PasswordValidate
import com.example.login_signup.util.validations.PhoneNoValidate
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignUpViewModel : AuthViewModel() {
    var signUpFormState by mutableStateOf(SignUpFormState())
    private val emailValidate = EmailValidate()
    private val passwordValidate = PasswordValidate()
    private val nameValidate = NameValidate()
    private val phoneNoValidate = PhoneNoValidate()

    private fun validateEmail(): Boolean {
        val emailResult = emailValidate.execute(signUpFormState.email)
        signUpFormState = signUpFormState.copy(emailError = emailResult.errorMessage)
        return emailResult.successful
    }

    private fun validatePassword(): Boolean {
        val passwordResult = passwordValidate.execute(signUpFormState.password)
        signUpFormState = signUpFormState.copy(passwordError = passwordResult.errorMessage)
        return passwordResult.successful
    }

    private fun validateName(): Boolean {
        val nameResult = nameValidate.execute(signUpFormState.fullName)
        signUpFormState = signUpFormState.copy(fullNameError = nameResult.errorMessage)
        return nameResult.successful
    }

    private fun validatePhoneNo(): Boolean {
        val phoneResult = phoneNoValidate.execute(signUpFormState.phoneNo)
        signUpFormState = signUpFormState.copy(phoneNoError = phoneResult.errorMessage)
        return phoneResult.successful
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
                    CoroutineScope(Dispatchers.Default).launch {
                        signUp(
                            signUpFormState.email,
                            signUpFormState.password
                        )
                    }
                }
            }
        }
    }
}