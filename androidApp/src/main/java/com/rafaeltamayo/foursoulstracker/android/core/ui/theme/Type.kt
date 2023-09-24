package com.rafaeltamayo.foursoulstracker.android.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rafaeltamayo.foursoulstracker.android.R

val FourSoulsFamily = FontFamily(
    Font(R.font.four_souls_body_regular, FontWeight.Normal),
    Font(R.font.four_souls_title_regular, FontWeight.Bold)
)

val typography = Typography(
    bodyMedium = TextStyle(
        fontFamily = FourSoulsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FourSoulsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),
    displayLarge = TextStyle(
        fontFamily = FourSoulsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp
    )
)