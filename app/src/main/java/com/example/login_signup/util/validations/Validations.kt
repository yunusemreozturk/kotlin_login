package com.example.login_signup.util.validations

import android.util.Patterns

class Validations {
    companion object {
        fun isNumber(value: String): Boolean {
            return value.isEmpty() || Regex("^\\d+\$").matches(value)
        }

        fun isName(value: String): Boolean {
            return value.length > 5
        }

        fun isEmailValid(email: String): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        fun isPasswordValid(password: String): Boolean {
            return password.any { it.isDigit() } &&
                    password.any { it.isLetter() }
        }
    }
}