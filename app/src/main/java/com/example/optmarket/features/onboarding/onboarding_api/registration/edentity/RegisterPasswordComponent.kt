package com.example.optmarket.features.onboarding.onboarding_api.registration.edentity

import kotlinx.coroutines.flow.StateFlow

interface RegisterPasswordComponent {

    val state : StateFlow<State>

    fun onBack()
    fun onPasswordChanged(password: String)
    fun onConfirmPasswordChanged(confirmPassword: String)
    fun onPasswordVisibilityChanged()
    fun onConfirmPasswordVisibilityChanged()

    data class State(
        val password: String,
        val passwordVisible: Boolean = false,
        val confirmPassword: String,
        val confirmPasswordVisible: Boolean = false
    )
}