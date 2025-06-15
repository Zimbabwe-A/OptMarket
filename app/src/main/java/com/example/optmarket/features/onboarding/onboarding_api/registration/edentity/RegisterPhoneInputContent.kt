package com.example.optmarket.features.onboarding.onboarding_api.registration.edentity

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.optmarket.core.composable_kit.app_bar.AppBar
import com.example.optmarket.core.composable_kit.app_button.AppButton
import com.example.optmarket.ui.theme.AppColor
import com.example.optmarket.ui.theme.AppTheme

@Composable
fun RegisterPhoneInputContent(
    component: RegisterPhoneInputComponent
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
        Spacer(Modifier.height(10.dp))
        Text(
            text = "Номер телефона",
            style = AppTheme.typography.headlineMedium,
            color = AppColor.Light.OnBackground
        )
        Spacer(Modifier.height(4.dp))
        OutlinedTextField(
            value = state.phone,
            onValueChange = component::onPhoneChange,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = AppTheme.typography.bodyLarge,
            maxLines = 1,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = AppColor.Light.PrimaryContainer,
                unfocusedContainerColor = AppColor.Light.PrimaryContainer,
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                focusedTextColor = AppColor.Light.OnPrimaryContainer,
                unfocusedTextColor = AppColor.Light.OnPrimaryContainer,
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        AppButton(
            title = "Продолжить",
            onClick = component::onContinue,
        )
        Spacer(modifier = Modifier.height(50.dp))
    }
}