package com.example.optmarket.features.onboarding.onboarding_api.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.optmarket.ui.theme.AppColor
import com.example.optmarket.ui.theme.AppTheme

@Composable
fun SplashContent(
    component: SplashComponent
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.Light.Background),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(400.dp)
                .rotate(45f)
                .background(AppColor.Light.PrimaryContainer),
            contentAlignment = Alignment.Center,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(280.dp)
                    .background(AppColor.Light.Primary),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    modifier = Modifier
                        .rotate(-45f)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Opt Market",
                        style = AppTheme.typography.displayLarge,
                        color = AppColor.Light.OnPrimary,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                    )
                    Text(
                        text = "beta",
                        style = AppTheme.typography.headlineMedium,
                        color = AppColor.Light.OnPrimary,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}
