package com.example.optmarket.features.onboarding.onboarding_impl.registration.edintity

import com.arkivanov.decompose.ComponentContext
import com.example.optmarket.features.onboarding.onboarding_api.registration.edentity.RegisterUserInfoComponent
import kotlinx.coroutines.flow.MutableStateFlow

class DefaultRegisterUserInfoComponent(
    componentContext: ComponentContext,
    var onBackClicked: () -> Unit,
    var onContinueClicked: () -> Unit,
) : RegisterUserInfoComponent, ComponentContext by componentContext {

    override val state = MutableStateFlow(RegisterUserInfoComponent.State(
        email = "",
        firstName = "",
        lastName = ""
    ))

    override fun onBack()  = onBackClicked()

    override fun onContinue() {
        onContinueClicked()
    }
}