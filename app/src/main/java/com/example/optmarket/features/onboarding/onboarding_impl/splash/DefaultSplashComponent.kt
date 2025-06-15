package com.example.optmarket.features.onboarding.onboarding_impl.splash

import com.arkivanov.decompose.ComponentContext
import com.example.optmarket.features.onboarding.onboarding_api.splash.SplashComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DefaultSplashComponent(
    componentContext: ComponentContext,
    private val onFinished: () -> Unit
): SplashComponent, ComponentContext by componentContext {

    private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    init {
        scope.launch {
            delay(2000)
            onFinished()
        }
    }

    override fun onDispose() {
        scope.cancel()
    }

}