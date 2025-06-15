package com.example.optmarket.features.onboarding.onboarding_impl.registration.edintity

import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import com.arkivanov.decompose.ComponentContext
import com.example.optmarket.features.onboarding.onboarding_api.registration.edentity.RegisterPhoneInputComponent
import kotlinx.coroutines.flow.MutableStateFlow


class DefaultRegisterPhoneInputComponent(
    componentContext: ComponentContext,
    private val onBackClicked: () -> Unit,
    private val onContinueClicked: () -> Unit,
) : RegisterPhoneInputComponent, ComponentContext by componentContext {

    override val state = MutableStateFlow(
        RegisterPhoneInputComponent.State()
    )

    override fun onContinue() {
        onContinueClicked()
    }

    override fun onBack() = onBackClicked()

    override fun onPhoneChange(value: TextFieldValue) {
        val prefix = "+7"
        val digits = value.text.removePrefix(prefix).filter { it.isDigit() }.take(10)
        val newText = prefix + digits
        val cursorPosition = newText.length
        state.value = state.value.copy(
            phone = TextFieldValue(
                text = newText,
                selection = TextRange(cursorPosition)
            )
        )
    }

    companion object {
        private const val PHONE_NUMBER_MAX_LENGTH = 10
    }
}
