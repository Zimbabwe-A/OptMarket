package com.example.optmarket.features.onboarding.onboarding_api.registration.edentity

import kotlinx.coroutines.flow.StateFlow

interface RegisterUserInfoComponent {

    val state : StateFlow<State>

    fun onBack()
    fun onContinue()

    fun onEmailChanged(email: String)
    fun onFirstNameChanged(firstName: String)
    fun onLastNameChanged(lastName: String)
    fun onWholesalerClick()
    fun onBuyerClick()

    data class State(
        val email: String,
        val firstName: String,
        val lastName: String,
        val wholesaler: Boolean,
        val buyer: Boolean
    )
}