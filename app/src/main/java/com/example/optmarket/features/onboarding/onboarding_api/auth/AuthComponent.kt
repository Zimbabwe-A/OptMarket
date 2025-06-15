package com.example.optmarket.features.onboarding.onboarding_api.auth

import com.example.optmarket.features.onboarding.onboarding_api.auth.component.AuthEmailFieldComponent
import com.example.optmarket.features.onboarding.onboarding_api.auth.component.AuthPasswordFieldComponent
import kotlinx.coroutines.flow.StateFlow

interface AuthComponent {

    val state: StateFlow<State>

    val authEmailFieldComponent: AuthEmailFieldComponent
    val authPasswordFieldComponent: AuthPasswordFieldComponent

    fun onBackClicked()
    fun authButtonClicked()
    fun onDismissRequest()

    data class State(
        val emailError: Boolean,
        val passwordError: Boolean,
        val emailOrPasswordError: Boolean,
        val onAuthContinue: Boolean
    )
}