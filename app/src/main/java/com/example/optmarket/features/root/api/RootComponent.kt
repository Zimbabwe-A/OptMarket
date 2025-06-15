package com.example.optmarket.features.root.api

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.example.optmarket.features.main.main_api.root.MainRootComponent
import com.example.optmarket.features.onboarding.onboarding_api.root.OnboardingRootComponent

interface RootComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed interface Child {
        class Onboarding(val component: OnboardingRootComponent) : Child
        class Main(val component: MainRootComponent) : Child
    }
}