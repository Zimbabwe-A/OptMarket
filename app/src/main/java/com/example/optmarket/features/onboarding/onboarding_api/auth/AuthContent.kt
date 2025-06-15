package com.example.optmarket.features.onboarding.onboarding_api.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.optmarket.R
import com.example.optmarket.core.composable_kit.app_bar.AppBar
import com.example.optmarket.core.composable_kit.app_button.AppButton
import com.example.optmarket.core.composable_kit.app_button.ButtonType
import com.example.optmarket.core.composable_kit.base_dialog.BaseDialogOne
import com.example.optmarket.features.onboarding.onboarding_api.auth.component.EmailFieldContent
import com.example.optmarket.features.onboarding.onboarding_api.auth.component.PasswordFieldContent
import com.example.optmarket.ui.theme.AppTheme

@Composable
fun AuthContent(component: AuthComponent) {
    val state = component.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
            .systemBarsPadding()
            .padding(horizontal = 16.dp),
    ) {
        AppBar(
            title = "Вход",
            onBackClicked = component::onBackClicked
        )
        Spacer(modifier = Modifier.height(30.dp))
        EmailFieldContent(component.authEmailFieldComponent)
        Spacer(modifier = Modifier.height(20.dp))
        PasswordFieldContent(component.authPasswordFieldComponent)
        Spacer(modifier = Modifier.height(40.dp))
        AppButton(
            title = "Войти",
            onClick = component::authButtonClicked,
            buttonType = ButtonType.Primary
        )
    }

    if (state.value.emailError) {
        BaseDialogOne(
            title = "Ошибка почты",
            icon = R.drawable.danger_circle,
            message = "Неверный формат\n электронной почты",
            onDismissRequest = component::onDismissRequest,
        )
    }

    if (state.value.passwordError) {
        BaseDialogOne(
            title = "Неверный формат\nпароля",
            icon = R.drawable.danger_circle,
            message = "Пароль должен быть\n больше 7 символов",
            onDismissRequest = component::onDismissRequest,
        )
    }

    if (state.value.emailOrPasswordError) {
        BaseDialogOne(
            title = "Ошибка входа",
            icon = R.drawable.danger_circle,
            message = "Неверная почта или пароль",
            onDismissRequest = component::onDismissRequest,
        )
    }
}