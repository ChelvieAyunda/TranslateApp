// ui/theme/Theme.kt
package com.chelvie.translateapp.ui.theme.screens

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme()
private val DarkColors = darkColorScheme()

@Composable
fun TranslateAppTheme(isDark: Boolean, content: @Composable () -> Unit) {
    val colors = if (isDark) DarkColors else LightColors
    MaterialTheme(colorScheme = colors, content = content)
}
