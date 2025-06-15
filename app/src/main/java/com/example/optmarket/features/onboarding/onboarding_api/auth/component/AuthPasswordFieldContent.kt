package com.example.optmarket.features.onboarding.onboarding_api.auth.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.optmarket.R
import com.example.optmarket.ui.theme.AppColor
import com.example.optmarket.ui.theme.AppTheme

@Composable
fun PasswordFieldContent(component: AuthPasswordFieldComponent) {
    val state by component.state.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Пароль",
            style = AppTheme.typography.headlineMedium,
            color = AppTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = state.password,
            textStyle = AppTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = component::onPasswordChange,
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
                    modifier = Modifier.clickable { component.togglePasswordVisibility() }
                )
            }
        )
    }
}