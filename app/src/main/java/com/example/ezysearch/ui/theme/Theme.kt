package com.example.ezysearch.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = Cyan50_200_Primary,
    primaryVariant = BlueA400_PrimaryVariant,
    secondary = YellowA400_Secondary,
    background = Gray800_Background,
    surface = Gray700_Surface,
    onPrimary = Blue_Gray900_OnPrimary,
    onSecondary = BlueGray50_OnSecondary,
    onBackground = Green900_OnBackground,
    onSurface = White_OnSurface,
    secondaryVariant = Gray700_secondaryVariant,
    error = Error
)

@Composable
fun EzySearchTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}