package com.example.optmarket.features.onboarding.onboarding_api.registration.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.example.optmarket.features.onboarding.onboarding_api.registration.edentity.RegisterPasswordContent
import com.example.optmarket.features.onboarding.onboarding_api.registration.edentity.RegisterPhoneInputContent
import com.example.optmarket.features.onboarding.onboarding_api.registration.edentity.RegisterUserInfoContent

@Composable
fun RegistrationRootContent(
    component: RegistrationRootComponent
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Children(
            stack = component.childStack,
            modifier = Modifier.fillMaxSize(),
            animation = stackAnimation(fade())
        ) {
            when (val child = it.instance) {
                is RegistrationRootComponent.Child.PhoneInput -> RegisterPhoneInputContent(component = child.component)
                is RegistrationRootComponent.Child.UserInfo -> RegisterUserInfoContent(component = child.component)
                is RegistrationRootComponent.Child.Password -> RegisterPasswordContent(component = child.component)
            }
        }
    }
}