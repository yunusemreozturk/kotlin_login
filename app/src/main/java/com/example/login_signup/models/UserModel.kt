package com.example.login_signup.models

data class UserModel(
    var id: String? = null,
    var email: String? = null,
    var fullName: String? = null,
    var phoneNo: String? = null,
    var password: String? = null
)