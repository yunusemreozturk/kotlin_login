package com.example.login_signup.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.login_signup.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontName1 = GoogleFont("Jockey One")

val fontName2 = GoogleFont("Inter")

val fontFamily1 = FontFamily(
    Font(googleFont = fontName1, fontProvider = provider)
)

val fontFamily2 = FontFamily(
    Font(googleFont = fontName2, fontProvider = provider)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = fontFamily1,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = fontFamily1,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = fontFamily2,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = fontFamily2,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
    ),
)