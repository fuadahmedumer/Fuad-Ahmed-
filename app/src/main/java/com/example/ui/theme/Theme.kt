package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = TealSecondary,
    onPrimary = Color.White,
    primaryContainer = TealDark,
    onPrimaryContainer = TealLight,
    secondary = GoldAccent,
    onSecondary = Color.Black,
    secondaryContainer = GoldDark,
    onSecondaryContainer = GoldContainer,
    background = Color(0xFF121A18),
    surface = Color(0xFF1A2422),
    onBackground = Color(0xFFE2E8F0),
    onSurface = Color(0xFFE2E8F0)
)

private val LightColorScheme = lightColorScheme(
    primary = TealPrimary,
    onPrimary = Color.White,
    primaryContainer = TealLight,
    onPrimaryContainer = TealDark,
    secondary = GoldAccent,
    onSecondary = Color.Black,
    secondaryContainer = GoldContainer,
    onSecondaryContainer = GoldDark,
    background = SurfaceSlate,
    surface = SurfaceCard,
    onBackground = TextDark,
    onSurface = TextDark,
    surfaceVariant = Color(0xFFE6EEEC),
    onSurfaceVariant = TextMuted,
    error = CrimsonError,
    errorContainer = ErrorContainer
)

@Composable
fun SubuluSalaamTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Set to false to preserve the distinct Markaza Teal & Gold branding
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
