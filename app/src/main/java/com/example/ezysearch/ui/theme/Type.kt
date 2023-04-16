package com.example.ezysearch.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ezysearch.R


val Courgette = FontFamily(
    Font(R.font.courgette_regular)
)

val SourcesSansProLightitalics = FontFamily(
    Font(R.font.sourcesanspro_lightitalic)
)
val offset = Offset(0.0f, 1.0f)
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h2 = TextStyle(
        fontFamily = Courgette,
        fontSize = 32.sp
    ),
    h3 = TextStyle(
        fontFamily = Courgette,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = SourcesSansProLightitalics,
        fontSize = 14.sp,
        shadow = Shadow(color = Color.White, offset = offset, blurRadius = 1f))

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)