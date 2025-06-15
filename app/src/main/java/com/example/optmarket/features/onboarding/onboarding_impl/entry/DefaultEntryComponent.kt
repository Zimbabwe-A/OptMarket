package com.example.optmarket.features.onboarding.onboarding_impl.entry

import com.arkivanov.decompose.ComponentContext
import com.example.optmarket.features.onboarding.onboarding_api.entry.EntryComponent

class DefaultEntryComponent(
    componentContext: ComponentContext,
    private val onAuth: () -> Unit,
    private val onRegister: () -> Unit
) : EntryComponent, ComponentContext by componentContext {
    override fun onLoginClick() = onAuth()
    override fun onRegisterClick() = onRegister()
}
