package com.example.lumos.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LumosColorScheme = lightColorScheme(
    primary = Green,
    secondary = LightBlue,
    background = Color.Magenta,
    onBackground = Black,
    surface = OffYellow,
    onSurface = Black
)

@Composable
fun LumosTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LumosColorScheme,
        typography = LumosTypography,
        content = content
    )
}