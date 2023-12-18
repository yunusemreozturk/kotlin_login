package com.example.login_signup.util

import android.util.Log

/* Custom Logger */
class CS {
    companion object {
        fun d(debug: String) {
            Log.d(APP_NAME, "Debug: $debug")
        }
        fun e(error: String) {
            Log.e(APP_NAME, "Error: $error")
        }
    }
}