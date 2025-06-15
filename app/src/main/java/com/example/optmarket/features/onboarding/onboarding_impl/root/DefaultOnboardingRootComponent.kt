package com.example.optmarket.features.onboarding.onboarding_impl.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.value.Value
import com.example.optmarket.features.onboarding.onboarding_api.root.OnboardingRootComponent
import com.example.optmarket.features.onboarding.onboarding_api.root.OnboardingRootComponent.Child.Auth
import com.example.optmarket.features.onboarding.onboarding_api.root.OnboardingRootComponent.Child.Entry
import com.example.optmarket.features.onboarding.onboarding_api.root.OnboardingRootComponent.Child.Splash
import com.example.optmarket.features.onboarding.onboarding_impl.auth.DefaultAuthComponent
import com.example.optmarket.features.onboarding.onboarding_impl.entry.DefaultEntryComponent
import com.example.optmarket.features.onboarding.onboarding_impl.registration.root.DefaultRegistrationRootComponent
import com.example.optmarket.features.onboarding.onboarding_impl.splash.DefaultSplashComponent
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent
import org.koin.core.component.get


class DefaultOnboardingRootComponent(
    componentContext: ComponentContext,
    private val onFinished: () -> Unit
) : OnboardingRootComponent, ComponentContext by componentContext, KoinComponent {

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack: Value<ChildStack<ChildConfig, OnboardingRootComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = ChildConfig.Splash,
            serializer = ChildConfig.serializer(),
            handleBackButton = true,
            childFactory = ::createChild
        )

    private fun createChild(
        config: ChildConfig,
        componentContext: ComponentContext
    ): OnboardingRootComponent.Child = when (config) {

        is ChildConfig.Splash -> {
            Splash(
                DefaultSplashComponent(
                    componentContext = componentContext,
                    onFinished = {
                        navigation.replaceAll(ChildConfig.Entry)
                    }
                )
            )
        }

        is ChildConfig.Entry -> {
            Entry(
                DefaultEntryComponent(
                    componentContext = componentContext,
                    onAuth = {
                        navigation.push(ChildConfig.Auth)
                    },
                    onRegister = {
                        navigation.push(ChildConfig.RegisterRoot)
                    })
            )
        }

        is ChildConfig.RegisterRoot -> {
            OnboardingRootComponent.Child.RegisterRoot(
                DefaultRegistrationRootComponent(
                    componentContext = componentContext,
                    onBacked = {
                        navigation.pop()
                    },
                )
            )
        }

        is ChildConfig.Auth -> {
            Auth(
                DefaultAuthComponent(
                    componentContext = componentContext,
                    onBackClick = {
                        navigation.pop()
                    },
                    onAuthButtonClicked = onFinished,
                    authEmailFieldComponent = get(),
                    authPasswordFieldComponent = get()
                )
            )
        }


    }

    @Serializable
    sealed interface ChildConfig {
        @Serializable
        object Entry : ChildConfig

        @Serializable
        object Auth : ChildConfig

        @Serializable
        object RegisterRoot : ChildConfig

        @Serializable
        object Splash : ChildConfig
    }
}