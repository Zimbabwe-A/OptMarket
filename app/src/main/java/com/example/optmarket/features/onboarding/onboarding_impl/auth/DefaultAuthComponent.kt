package com.example.optmarket.features.onboarding.onboarding_impl.auth

import com.arkivanov.decompose.ComponentContext
import com.example.optmarket.core.utils.ValidationUtils
import com.example.optmarket.features.onboarding.onboarding_api.auth.AuthComponent
import com.example.optmarket.features.onboarding.onboarding_api.auth.component.AuthEmailFieldComponent
import com.example.optmarket.features.onboarding.onboarding_api.auth.component.AuthPasswordFieldComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

class DefaultAuthComponent(
    componentContext: ComponentContext,
    private val onBackClick: () -> Unit,
    private val onAuthButtonClicked: () -> Unit,
    override val authEmailFieldComponent: AuthEmailFieldComponent,
    override val authPasswordFieldComponent: AuthPasswordFieldComponent
) : AuthComponent, ComponentContext by componentContext {

    override val state = MutableStateFlow(
        AuthComponent.State(
            emailError = false,
            passwordError = false,
            emailOrPasswordError = false,
            onAuthContinue = false
        )
    )

    override fun onDismissRequest() {
        state.update {
            it.copy(
                emailError = false,
                emailOrPasswordError = false,
                passwordError = false
            )
        }
    }

    override fun onBackClicked() = onBackClick()

    override fun authButtonClicked() {
        val email = authEmailFieldComponent.state.value.email
        val password = authPasswordFieldComponent.state.value.password

        if(!ValidationUtils.isValidEmail(email)) {
            state.update { it.copy(emailError = true) }
            return
        }
        if(!ValidationUtils.isValidPassword(password)) {
            state.update { it.copy(passwordError = true) }
            return
        }

        if(email == "gaga@mail.ru" && password == "123456789") {
            onAuthButtonClicked()
        } else {
            state.update { it.copy(emailOrPasswordError = true) }
        }
    }
}