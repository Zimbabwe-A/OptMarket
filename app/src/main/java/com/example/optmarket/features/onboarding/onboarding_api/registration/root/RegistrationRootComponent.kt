package com.example.optmarket.features.onboarding.onboarding_api.registration.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.example.optmarket.features.onboarding.onboarding_api.registration.edentity.RegisterPasswordComponent
import com.example.optmarket.features.onboarding.onboarding_api.registration.edentity.RegisterPhoneInputComponent
import com.example.optmarket.features.onboarding.onboarding_api.registration.edentity.RegisterUserInfoComponent

interface RegistrationRootComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed interface Child {
        class PhoneInput(val component: RegisterPhoneInputComponent) : Child
        class UserInfo(val component: RegisterUserInfoComponent) : Child
        class Password(val component: RegisterPasswordComponent) : Child
    }

    fun onBack()
}