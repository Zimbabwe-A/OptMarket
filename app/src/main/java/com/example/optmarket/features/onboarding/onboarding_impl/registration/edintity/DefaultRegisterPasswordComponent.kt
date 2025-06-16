package com.example.optmarket.features.onboarding.onboarding_impl.registration.edintity

import com.arkivanov.decompose.ComponentContext
import com.example.optmarket.features.onboarding.onboarding_api.registration.edentity.RegisterPasswordComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class DefaultRegisterPasswordComponent(
    componentContext: ComponentContext,
    val onBackClicked: () -> Unit,
): RegisterPasswordComponent, ComponentContext by componentContext {

    override val state = MutableStateFlow(RegisterPasswordComponent.State(
        password = "",
        confirmPassword = ""
    ))

    override fun onBack() = onBackClicked()

    override fun onConfirmPasswordChanged(confirmPassword: String) {
        state.update { it.copy(confirmPassword= confirmPassword) }
    }

    override fun onPasswordChanged(password: String) {
        state.update { it.copy(password = password) }
    }

    override fun onPasswordVisibilityChanged() {
        state.update { it.copy(passwordVisible = !it.passwordVisible) }
    }

    override fun onConfirmPasswordVisibilityChanged() {
        state.update { it.copy(confirmPasswordVisible = !it.confirmPasswordVisible) }
    }
}