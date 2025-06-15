package com.example.optmarket.features.onboarding.onboarding_api.auth.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.optmarket.ui.theme.AppColor
import com.example.optmarket.ui.theme.AppTheme


@Composable
fun EmailFieldContent(component: AuthEmailFieldComponent) {
    val state by component.state.collectAsStateWithLifecycle()


    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Почта",
            style = AppTheme.typography.headlineMedium,
            color = AppTheme.colors.onBackground
        )
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = state.email,
            textStyle = AppTheme.typography.bodyLarge,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = component::emailChanged,
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
    }
}