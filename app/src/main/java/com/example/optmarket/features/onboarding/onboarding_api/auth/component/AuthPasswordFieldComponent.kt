package com.example.optmarket.features.onboarding.onboarding_api.auth.component


import kotlinx.coroutines.flow.StateFlow

interface AuthPasswordFieldComponent {

    val state: StateFlow<State>

    fun onPasswordChange(password: String)

    fun togglePasswordVisibility()

    data class  State(
        val password: String,
        val passwordVisible: Boolean = false

    )
}