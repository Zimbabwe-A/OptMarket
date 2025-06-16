package com.example.optmarket.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


val AppTypography = Typography(
    displayLarge = TextStyle( // 🔠 Очень крупный заголовок
        fontSize = 44.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = (-0.5).sp
    ),
    headlineLarge = TextStyle( // 🔠 Заголовок экрана
        fontSize = 26.sp,
        fontWeight = FontWeight(600),
        letterSpacing = 0.sp,
    ),
    headlineMedium = TextStyle( // 🔠 Подзаголовок
        fontSize = 22.sp,
        fontWeight = FontWeight(500),
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle( // 🏷️ Названия разделов, карточек
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.15.sp
    ),
    titleMedium = TextStyle( // 🏷️ Заголовок элемента списка
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.1.sp
    ),
    bodyLarge = TextStyle( // 📄 Обычный текст
        fontSize = 16.sp,
        fontWeight = FontWeight(400),
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle( // 📄 Текст поменьше (описания)
        fontSize = 14.sp,
        fontWeight = FontWeight(400),
        letterSpacing = 0.25.sp
    ),
    labelLarge = TextStyle( // 🏷️ Текст на кнопках
        fontSize = 15.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle( // 🏷️ Мелкие метки (в фильтрах, меню)
        fontSize = 12.sp,
        fontWeight = FontWeight(500),
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle( // 🏷️ Подписи к иконкам, табам
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.5.sp
    )
)