package com.example.login_signup.util.validations

import com.example.login_signup.R
import com.example.login_signup.util.UiText

class PhoneNoValidate : BaseUseCase<String, ValidationResult> {

    override fun execute(input: String): ValidationResult {
        if (input.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.cannot_be_blank),
            )
        }

        if (!Validations.isNumber(input)) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.phone_number_should_be_content_just_digit),
            )
        }

        return ValidationResult(
            successful = true,
            errorMessage = null
        )
    }
}