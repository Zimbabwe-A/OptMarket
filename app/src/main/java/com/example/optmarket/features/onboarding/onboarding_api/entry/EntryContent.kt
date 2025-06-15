package com.example.optmarket.features.onboarding.onboarding_api.entry

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.optmarket.core.composable_kit.app_button.AppButton
import com.example.optmarket.ui.theme.AppTheme

@Composable
fun EntryContent(component: EntryComponent) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AppButton(
            title = "Войти",
            onClick = component::onLoginClick,
        )
        Spacer(modifier = Modifier.height(20.dp))
        AppButton(
            title = "Регистрация",
            onClick =  component::onRegisterClick
        )
    }
}