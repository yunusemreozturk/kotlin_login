package com.example.login_signup.util.validations

import com.example.login_signup.util.UiText

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: UiText? = null
)