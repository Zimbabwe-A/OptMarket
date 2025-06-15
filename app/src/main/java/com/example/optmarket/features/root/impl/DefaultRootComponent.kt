package com.example.optmarket.features.root.impl

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceAll
import com.arkivanov.decompose.value.Value
import com.example.optmarket.features.main.main_impl.root.DefaultMainRootComponent
import com.example.optmarket.features.onboarding.onboarding_impl.root.DefaultOnboardingRootComponent
import com.example.optmarket.features.root.api.RootComponent
import com.example.optmarket.features.root.api.RootComponent.Child.Main
import com.example.optmarket.features.root.api.RootComponent.Child.Onboarding
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext, KoinComponent {

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack: Value<ChildStack<ChildConfig, RootComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = ChildConfig.Onboarding,
            serializer = ChildConfig.serializer(),
            handleBackButton = true,
            childFactory = ::createChild
        )

    private fun createChild(
        config: ChildConfig,
        componentContext: ComponentContext
    ): RootComponent.Child = when (config) {
        is ChildConfig.Onboarding -> {
            Onboarding(
                DefaultOnboardingRootComponent(
                    componentContext = componentContext,
                    onFinished = {
                        navigation.replaceAll(ChildConfig.Main)
                    }
                )
            )
        }
        is ChildConfig.Main -> {
            Main(
                DefaultMainRootComponent(
                    componentContext = componentContext
                )
            )
        }
    }

    @Serializable
    sealed interface ChildConfig {

        @Serializable
        object Onboarding : ChildConfig

        @Serializable
        object Main : ChildConfig
    }
}