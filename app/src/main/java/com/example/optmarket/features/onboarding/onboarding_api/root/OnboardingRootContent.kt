package com.example.optmarket.features.onboarding.onboarding_api.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.example.optmarket.features.onboarding.onboarding_api.auth.AuthContent
import com.example.optmarket.features.onboarding.onboarding_api.entry.EntryContent
import com.example.optmarket.features.onboarding.onboarding_api.registration.root.RegistrationRootContent
import com.example.optmarket.features.onboarding.onboarding_api.splash.SplashContent

@Composable
fun OnboardingRootContent(component: OnboardingRootComponent) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Children(
            stack = component.childStack,
            modifier = Modifier.fillMaxSize(),
            animation = stackAnimation(fade())
        ) {
            when (val child = it.instance) {
                is OnboardingRootComponent.Child.Splash -> SplashContent(component = child.component)
                is OnboardingRootComponent.Child.Entry -> EntryContent(component = child.component)
                is OnboardingRootComponent.Child.Auth -> AuthContent(component = child.component)
                is OnboardingRootComponent.Child.RegisterRoot -> RegistrationRootContent(component = child.component)
            }
        }
    }
}
