package com.example.optmarket.ui.theme


import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

object AppTheme {

    val colors: Colors
        @Composable
        get() = Colors(
            primary = MaterialTheme.colorScheme.primary,
            onPrimary = MaterialTheme.colorScheme.onPrimary,
            secondary = MaterialTheme.colorScheme.secondary,
            onSecondary = MaterialTheme.colorScheme.onSecondary,
            background = MaterialTheme.colorScheme.background,
            onBackground = MaterialTheme.colorScheme.onBackground,
            surface = MaterialTheme.colorScheme.surface,
            onSurface = MaterialTheme.colorScheme.onSurface,
            error = MaterialTheme.colorScheme.error,
            onError = MaterialTheme.colorScheme.onError,
            icon = AppColor.Light.icon
        )
    val typography: Typography
        @Composable
        get() = Typography(
            displayLarge = AppTypography.displayLarge,
            headlineLarge = AppTypography.headlineLarge,
            headlineMedium = AppTypography.headlineMedium,
            titleLarge = AppTypography.titleLarge,
            titleMedium = AppTypography.titleMedium,
            bodyLarge = AppTypography.bodyLarge,
            bodyMedium = AppTypography.bodyMedium,
            labelLarge = AppTypography.labelLarge,
            labelMedium = AppTypography.labelMedium,
            labelSmall = AppTypography.labelSmall,
        )
}

data class Colors(
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val error: Color,
    val onError: Color,
    val icon: Color,
)

data class Typography(
    val displayLarge: TextStyle,
    val headlineLarge: TextStyle,
    val headlineMedium: TextStyle,
    val titleLarge: TextStyle,
    val titleMedium: TextStyle,
    val bodyLarge: TextStyle,
    val bodyMedium: TextStyle,
    val labelLarge: TextStyle,
    val labelMedium: TextStyle,
    val labelSmall: TextStyle,
)
