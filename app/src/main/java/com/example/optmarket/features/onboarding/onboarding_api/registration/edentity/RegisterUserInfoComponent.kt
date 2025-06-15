package com.example.optmarket.features.onboarding.onboarding_api.registration.edentity

import kotlinx.coroutines.flow.StateFlow

interface RegisterUserInfoComponent {

    val state : StateFlow<State>

    fun onBack()
    fun onContinue()

    data class State(
        val email: String,
        val firstName: String,
        val lastName: String
    )
}