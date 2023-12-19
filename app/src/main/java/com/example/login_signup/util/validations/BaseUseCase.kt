package com.example.login_signup.util.validations

interface BaseUseCase<In, Out> {
    fun execute(input: In): Out
}