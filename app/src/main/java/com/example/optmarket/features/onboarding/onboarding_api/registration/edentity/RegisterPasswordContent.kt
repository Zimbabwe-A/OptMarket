package com.example.optmarket.features.onboarding.onboarding_api.registration.edentity

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.optmarket.R
import com.example.optmarket.core.composable_kit.app_bar.AppBar
import com.example.optmarket.ui.theme.AppColor
import com.example.optmarket.ui.theme.AppTheme

@Composable
fun RegisterPasswordContent(
    component: RegisterPasswordComponent
) {
    val state by component.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.Light.Background)
            .systemBarsPadding()
            .padding(horizontal = 16.dp),
    ) {
        AppBar(
            title = "Регистрация",
            onBackClicked = component::onBack
        )
        Password(state, component)
        Spacer(modifier = Modifier.height(15.dp))
        ConfirmPassword(state, component)
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(AppColor.Light.Surface)
                .padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
            Column {
                Text(
                    text = "Пароль должен содержать:",
                    style = AppTheme.typography.bodyMedium,
                    color = AppColor.Light.OnSurface
                )
                Spacer(Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.danger_circle),
                        contentDescription = "Условие",
                        modifier = Modifier.size(12.dp),
                        tint = AppColor.Light.negativeIcon,
                    )
                    Spacer(Modifier.width(5.dp))
                    Text(
                        text = "Не менее 8 символов",
                        style = AppTheme.typography.labelMedium,
                        color = AppColor.Light.negativeIcon
                    )
                }
                Spacer(Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.danger_circle),
                        contentDescription = "Условие",
                        modifier = Modifier.size(12.dp),
                        tint = AppColor.Light.negativeIcon,
                    )
                    Spacer(Modifier.width(5.dp))
                    Text(
                        text = "Только латинские буквы",
                        style = AppTheme.typography.labelMedium,
                        color = AppColor.Light.negativeIcon
                    )
                }
            }
        }
    }
}

@Composable
private fun Password(
    state: RegisterPasswordComponent.State,
    component: RegisterPasswordComponent
) {
    Text(
        text = "Пароль",
        style = AppTheme.typography.headlineMedium,
        color = AppTheme.colors.onBackground
    )
    Spacer(modifier = Modifier.height(4.dp))
    OutlinedTextField(
        value = state.password,
        placeholder = { Text("Введите пароль") },
        textStyle = AppTheme.typography.bodyLarge,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = component::onPasswordChanged,
        maxLines = 1,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = AppColor.Light.PrimaryContainer,
            unfocusedContainerColor = AppColor.Light.PrimaryContainer,
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            focusedTextColor = AppColor.Light.OnPrimaryContainer,
            unfocusedTextColor = AppColor.Light.OnPrimaryContainer,
        ),
        visualTransformation = if (state.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (state.passwordVisible)
                R.drawable.visible
            else R.drawable.visible_off

            val description = if (state.passwordVisible) "Скрыть пароль" else "Показать пароль"

            Icon(
                painter = painterResource(image),
                contentDescription = description,
                modifier = Modifier.clickable { component.onPasswordVisibilityChanged() }
            )
        }
    )
}

@Composable
private fun ConfirmPassword(
    state: RegisterPasswordComponent.State,
    component: RegisterPasswordComponent
) {
    Text(
        text = "Повторите пароль",
        style = AppTheme.typography.headlineMedium,
        color = AppTheme.colors.onBackground
    )
    Spacer(modifier = Modifier.height(4.dp))
    OutlinedTextField(
        value = state.confirmPassword,
        placeholder = { Text("Введите пароль") },
        textStyle = AppTheme.typography.bodyLarge,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = component::onConfirmPasswordChanged,
        maxLines = 1,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = AppColor.Light.PrimaryContainer,
            unfocusedContainerColor = AppColor.Light.PrimaryContainer,
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            focusedTextColor = AppColor.Light.OnPrimaryContainer,
            unfocusedTextColor = AppColor.Light.OnPrimaryContainer,
        ),
        visualTransformation = if (state.confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (state.confirmPasswordVisible)
                R.drawable.visible
            else R.drawable.visible_off

            val description =
                if (state.confirmPasswordVisible) "Скрыть пароль" else "Показать пароль"

            Icon(
                painter = painterResource(image),
                contentDescription = description,
                modifier = Modifier.clickable { component.onConfirmPasswordVisibilityChanged() }
            )
        }
    )
}