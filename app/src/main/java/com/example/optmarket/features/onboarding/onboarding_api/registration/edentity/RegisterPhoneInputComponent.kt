package com.example.optmarket.features.onboarding.onboarding_api.registration.edentity

import androidx.compose.ui.text.input.TextFieldValue
import kotlinx.coroutines.flow.StateFlow

interface RegisterPhoneInputComponent {

    val state: StateFlow<State>

    fun onPhoneChange(value: TextFieldValue)
    fun onContinue()
    fun onBack()

    data class State(
        val phone: TextFieldValue = TextFieldValue("+7")
    )
}