package com.example.optmarket.features.onboarding.onboarding_impl.registration.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.example.optmarket.features.onboarding.onboarding_api.registration.root.RegistrationRootComponent
import com.example.optmarket.features.onboarding.onboarding_impl.registration.edintity.DefaultRegisterPasswordComponent
import com.example.optmarket.features.onboarding.onboarding_impl.registration.edintity.DefaultRegisterPhoneInputComponent
import com.example.optmarket.features.onboarding.onboarding_impl.registration.edintity.DefaultRegisterUserInfoComponent
import kotlinx.serialization.Serializable
import org.koin.core.component.KoinComponent

class DefaultRegistrationRootComponent(
    componentContext: ComponentContext,
    val onBacked: () -> Unit
) : RegistrationRootComponent, ComponentContext by componentContext, KoinComponent {

    private val navigation = StackNavigation<ChildConfig>()

    override val childStack = childStack(
        source = navigation,
        initialConfiguration = ChildConfig.PhoneInput,
        serializer = ChildConfig.serializer(),
        handleBackButton = true,
        childFactory = ::createChild
    )


    private fun createChild(config: ChildConfig, componentContext: ComponentContext): RegistrationRootComponent.Child {
        return when (config) {
            is ChildConfig.PhoneInput -> {
                RegistrationRootComponent.Child.PhoneInput(
                    DefaultRegisterPhoneInputComponent(
                        componentContext = componentContext,
                        onBackClicked = onBacked,
                        onContinueClicked = {
                            navigation.pushNew(ChildConfig.UserInfo)
                        }
                    )
                )
            }

            is ChildConfig.UserInfo -> {
                RegistrationRootComponent.Child.UserInfo(
                    DefaultRegisterUserInfoComponent(
                        componentContext = componentContext,
                        onBackClicked = {
                            navigation.pop()
                        },
                        onContinueClicked = {
                            navigation.pushNew(ChildConfig.Password)
                        }
                    )
                )
            }

            is ChildConfig.Password -> {
                RegistrationRootComponent.Child.Password(
                    DefaultRegisterPasswordComponent(
                        componentContext = componentContext,
                        onBackClicked = {
                            navigation.pop()
                        },
                    )
                )
            }
        }
    }

    override fun onBack() {
        navigation.pop()
    }


    @Serializable
    sealed interface ChildConfig {
        @Serializable
        object PhoneInput : ChildConfig

        @Serializable
        object UserInfo : ChildConfig

        @Serializable
        object Password : ChildConfig
    }
}