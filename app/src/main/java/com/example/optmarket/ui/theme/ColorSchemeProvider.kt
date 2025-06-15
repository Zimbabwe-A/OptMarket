package com.example.optmarket.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

fun lightColorSchemeFromAppColors(): ColorScheme = lightColorScheme(
    primary = AppColor.Light.Primary,
    onPrimary = AppColor.Light.OnPrimary,
    primaryContainer = AppColor.Light.PrimaryContainer,
    onPrimaryContainer = AppColor.Light.OnPrimaryContainer,

    secondary = AppColor.Light.Secondary,
    onSecondary = AppColor.Light.OnSecondary,
    secondaryContainer = AppColor.Light.SecondaryContainer,
    onSecondaryContainer = AppColor.Light.OnSecondaryContainer,

    background = AppColor.Light.Background,
    onBackground = AppColor.Light.OnBackground,

    surface = AppColor.Light.Surface,
    onSurface = AppColor.Light.OnSurface,

    error = AppColor.Light.Error,
    onError = AppColor.Light.OnError,
)

fun darkColorSchemeFromAppColors(): ColorScheme = darkColorScheme(
    primary = AppColor.Dark.Primary,
    onPrimary = AppColor.Dark.OnPrimary,
    primaryContainer = AppColor.Dark.PrimaryContainer,
    onPrimaryContainer = AppColor.Dark.OnPrimaryContainer,

    secondary = AppColor.Dark.Secondary,
    onSecondary = AppColor.Dark.OnSecondary,
    secondaryContainer = AppColor.Dark.SecondaryContainer,
    onSecondaryContainer = AppColor.Dark.OnSecondaryContainer,

    background = AppColor.Dark.Background,
    onBackground = AppColor.Dark.OnBackground,

    surface = AppColor.Dark.Surface,
    onSurface = AppColor.Dark.OnSurface,

    error = AppColor.Dark.Error,
    onError = AppColor.Dark.OnError
)
