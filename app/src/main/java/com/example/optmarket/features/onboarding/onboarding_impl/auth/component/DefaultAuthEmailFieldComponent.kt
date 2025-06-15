package com.example.optmarket.features.onboarding.onboarding_impl.auth.component

import com.example.optmarket.features.onboarding.onboarding_api.auth.component.AuthEmailFieldComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class DefaultAuthEmailFieldComponent: AuthEmailFieldComponent {

    override val state = MutableStateFlow(AuthEmailFieldComponent.State(
        email = "",
        emailValid = false,
    ))

    override fun emailChanged(email: String) {
        state.update { it.copy(email = email) }
    }

}