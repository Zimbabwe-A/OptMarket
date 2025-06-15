package com.example.optmarket.features.onboarding.onboarding_impl.auth.component


import com.example.optmarket.features.onboarding.onboarding_api.auth.component.AuthPasswordFieldComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class DefaultAuthPasswordFiledComponent : AuthPasswordFieldComponent {
    override val state = MutableStateFlow(
        AuthPasswordFieldComponent.State(
            password = ""
        )
    )

    override fun onPasswordChange(password: String) {
        state.update { it.copy(password = password) }
    }

    override fun togglePasswordVisibility() {
        state.update { it.copy(passwordVisible = !it.passwordVisible) }
    }

}