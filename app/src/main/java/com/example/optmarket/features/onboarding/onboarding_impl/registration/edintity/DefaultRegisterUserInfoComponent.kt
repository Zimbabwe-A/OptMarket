package com.example.optmarket.features.onboarding.onboarding_impl.registration.edintity

import com.arkivanov.decompose.ComponentContext
import com.example.optmarket.features.onboarding.onboarding_api.registration.edentity.RegisterUserInfoComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class DefaultRegisterUserInfoComponent(
    componentContext: ComponentContext,
    var onBackClicked: () -> Unit,
    var onContinueClicked: () -> Unit,
) : RegisterUserInfoComponent, ComponentContext by componentContext {

    override val state = MutableStateFlow(RegisterUserInfoComponent.State(
        email = "",
        firstName = "",
        lastName = "",
        wholesaler = false,
        buyer = false,
    ))

    override fun onEmailChanged(email: String) {
        state.update { it.copy(email = email) }
    }

    override fun onFirstNameChanged(firstName: String) {
        state.update { it.copy(firstName = firstName) }
    }

    override fun onLastNameChanged(lastName: String) {
        state.update { it.copy(lastName = lastName) }
    }

    override fun onBuyerClick() {
        state.update { it.copy(
            buyer = true,
            wholesaler = false,
        ) }
    }

    override fun onWholesalerClick() {
        state.update { it.copy(
            buyer = false,
            wholesaler = true,
        ) }
    }

    override fun onBack()  = onBackClicked()

    override fun onContinue() {
        onContinueClicked()
    }
}