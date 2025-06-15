package com.example.optmarket.features.root.api

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.example.optmarket.features.main.main_api.root.MainRootContent
import com.example.optmarket.features.onboarding.onboarding_api.root.OnboardingRootContent

@Composable
fun RootComponent(
    component: RootComponent
) {
    Surface {
        Children(
            stack = component.childStack,
            modifier = Modifier.fillMaxSize(),
            animation = stackAnimation(fade())
        ) {
            when (val child = it.instance) {
                is RootComponent.Child.Onboarding -> OnboardingRootContent(component = child.component)
                is RootComponent.Child.Main -> MainRootContent(component = child.component)
            }
        }
    }
}