package com.example.optmarket.features.onboarding.onboarding_api.auth.component

import kotlinx.coroutines.flow.StateFlow

interface AuthEmailFieldComponent {

    val state: StateFlow<State>

    fun emailChanged(email: String)

    data class  State(
        val email: String ,
        val emailValid: Boolean
    )
}