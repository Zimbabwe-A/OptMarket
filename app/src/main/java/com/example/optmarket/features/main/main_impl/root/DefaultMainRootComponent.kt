package com.example.optmarket.features.main.main_impl.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.example.optmarket.features.main.main_api.root.MainRootComponent
import com.example.optmarket.features.main.main_api.root.MainRootComponent.Child.Home
import com.example.optmarket.features.main.main_impl.home.DefaultHomeComponent
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent

class DefaultMainRootComponent(
    componentContext: ComponentContext
) : MainRootComponent, ComponentContext by componentContext, KoinComponent {

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack: Value<ChildStack<ChildConfig, MainRootComponent.Child>> =
        childStack(
            source = navigation,
            initialConfiguration = ChildConfig.Home,
            serializer = ChildConfig.serializer(),
            handleBackButton = true,
            childFactory = ::createChild
        )

    private fun createChild(
        config: ChildConfig,
        componentContext: ComponentContext
    ): MainRootComponent.Child = when (config) {
        is ChildConfig.Home -> {
            Home(
                DefaultHomeComponent(
                    componentContext = componentContext
                )
            )
        }
    }

    @Serializable
    sealed interface ChildConfig {

        @Serializable
        object Home : ChildConfig
    }
}