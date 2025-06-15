package com.example.optmarket.features.onboarding.onboarding_impl.di

import com.arkivanov.decompose.ComponentContext
import com.example.optmarket.features.onboarding.onboarding_api.auth.AuthComponent
import com.example.optmarket.features.onboarding.onboarding_api.auth.component.AuthEmailFieldComponent
import com.example.optmarket.features.onboarding.onboarding_api.auth.component.AuthPasswordFieldComponent
import com.example.optmarket.features.onboarding.onboarding_api.entry.EntryComponent
import com.example.optmarket.features.onboarding.onboarding_impl.auth.DefaultAuthComponent
import com.example.optmarket.features.onboarding.onboarding_impl.auth.component.DefaultAuthEmailFieldComponent
import com.example.optmarket.features.onboarding.onboarding_impl.auth.component.DefaultAuthPasswordFiledComponent
import com.example.optmarket.features.onboarding.onboarding_impl.entry.DefaultEntryComponent
import org.koin.dsl.module

val onboardingModule = module {

//    Entry
    factory<EntryComponent> { (componentContext: ComponentContext, onAuth: () -> Unit, onRegister: () -> Unit) ->
        DefaultEntryComponent(
            componentContext = componentContext,
            onAuth = onAuth,
            onRegister = onRegister
        )
    }

//    Auth
    factory<AuthComponent> { (
                                 componentContext: ComponentContext,
                                 onBackClick: () -> Unit,
                                 onAuthButtonClicked: () -> Unit
                             ) ->
        DefaultAuthComponent(
            componentContext = componentContext,
            onBackClick = onBackClick,
            onAuthButtonClicked = onAuthButtonClicked,
            authEmailFieldComponent = get(),
            authPasswordFieldComponent = get()
        )
    }

    factory<AuthPasswordFieldComponent> {
        DefaultAuthPasswordFiledComponent()
    }

    factory<AuthEmailFieldComponent> {
        DefaultAuthEmailFieldComponent()
    }
}