package com.example.optmarket.features.onboarding.onboarding_api.registration.edentity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.optmarket.core.composable_kit.app_bar.AppBar
import com.example.optmarket.ui.theme.AppColor

@Composable
fun RegisterUserInfoContent(
    component: RegisterUserInfoComponent
) {
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
    }
}