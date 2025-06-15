package com.example.optmarket.di

import com.example.optmarket.features.main.main_impl.di.mainModule
import com.example.optmarket.features.onboarding.onboarding_impl.di.onboardingModule

val allModules = listOf(
    onboardingModule,
    mainModule
)