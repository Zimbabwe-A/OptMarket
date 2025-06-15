package com.example.optmarket.features.onboarding.onboarding_api.root


import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.example.optmarket.features.onboarding.onboarding_api.auth.AuthComponent
import com.example.optmarket.features.onboarding.onboarding_api.entry.EntryComponent
import com.example.optmarket.features.onboarding.onboarding_api.registration.root.RegistrationRootComponent
import com.example.optmarket.features.onboarding.onboarding_api.splash.SplashComponent


interface OnboardingRootComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed interface Child {
        class Splash(val component: SplashComponent) : Child
        class Entry(val component: EntryComponent) : Child
        class Auth(val component: AuthComponent) : Child
        class RegisterRoot(val component: RegistrationRootComponent): Child
    }
}