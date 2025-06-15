package com.example.optmarket.ui.theme

import androidx.compose.ui.graphics.Color

object AppColor {

    object Light {
        // 🟩 Основной цвет (бренд, кнопки, акцентные элементы интерфейса)
        var Primary = Color(0xFF2E7D32)              // Зелёный — надёжность, успех
        var OnPrimary = Color(0xFFFFFFFF)            // Цвет текста на фоне primary
        var PrimaryContainer = Color(0xFFA5D6A7)     // Светлая версия primary для карточек, фонов
        var OnPrimaryContainer = Color(0xFF003300)  // Текст на фоне primaryContainer

        // 🟦 Вторичный цвет (дополнительные акценты, иконки, фильтры)
        var Secondary = Color(0xFF00ACC1)           // Голубой — акценты, категории, фильтры
        var OnSecondary = Color(0xFFFFFFFF)         // Текст/иконки на secondary
        var SecondaryContainer = Color(0xFFB2EBF2)   // Светлый голубой — фоны, иконки
        var OnSecondaryContainer = Color(0xFF004D40) // Текст на фоне secondaryContainer

        // ⚪ Фоновый цвет (основной цвет экрана)
        var Background = Color(0xFFE8F5E9)           // Очень светло-зелёный фон — чистый, лёгкий
        var OnBackground = Color(0xFF1B1B1B)         // Основной цвет текста на фоне

        // ⬜ Поверхности (карточки, модальные окна и т.п.)
        var Surface = Color(0xFFFFFFFF)              // Белый фон для карточек и блоков
        var OnSurface = Color(0xFF1B1B1B)            // Тёмный текст на поверхности

        // ❌ Цвета для ошибок и предупреждений
        var Error = Color(0xFFB00020)                // Красный — ошибки, недоступность
        var OnError = Color(0xFFFFFFFF)              // Белый текст на ошибочном фоне

        var icon = Color(0xFF33363F)
        val negativeIconBg = Color(0xFFFCE8EB)
        val negativeIcon = Color(0xFFEB2F48)
    }

    object Dark {
        // 🟩 Основной цвет (бренд, кнопки, акцентные элементы интерфейса)
        var Primary = Color(0xFF2E7D32)              // Зелёный — надёжность, успех
        var OnPrimary = Color(0xFFFFFFFF)            // Цвет текста на фоне primary
        var PrimaryContainer = Color(0xFFA5D6A7)     // Светлая версия primary для карточек, фонов
        var OnPrimaryContainer = Color(0xFF003300)  // Текст на фоне primaryContainer

        // 🟦 Вторичный цвет (дополнительные акценты, иконки, фильтры)
        var Secondary = Color(0xFF00ACC1)           // Голубой — акценты, категории, фильтры
        var OnSecondary = Color(0xFFFFFFFF)         // Текст/иконки на secondary
        var SecondaryContainer = Color(0xFFB2EBF2)   // Светлый голубой — фоны, иконки
        var OnSecondaryContainer = Color(0xFF004D40) // Текст на фоне secondaryContainer

        // ⚪ Фоновый цвет (основной цвет экрана)
        var Background = Color(0xFFE8F5E9)           // Очень светло-зелёный фон — чистый, лёгкий
        var OnBackground = Color(0xFF1B1B1B)         // Основной цвет текста на фоне

        // ⬜ Поверхности (карточки, модальные окна и т.п.)
        var Surface = Color(0xFFFFFFFF)              // Белый фон для карточек и блоков
        var OnSurface = Color(0xFF1B1B1B)            // Тёмный текст на поверхности

        // ❌ Цвета для ошибок и предупреждений
        var Error = Color(0xFFB00020)                // Красный — ошибки, недоступность
        var OnError = Color(0xFFFFFFFF)              // Белый текст на ошибочном фоне

        var icon = Color(0xFF33363F)
        val negativeIconBg = Color(0xFFFCE8EB)
        val negativeIcon = Color(0xFFEB2F48)
    }
}