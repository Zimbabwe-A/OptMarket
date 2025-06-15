package com.example.optmarket.features.main.main_impl.home

import com.arkivanov.decompose.ComponentContext
import com.example.optmarket.features.main.main_api.home.HomeComponent

class DefaultHomeComponent(
    componentContext: ComponentContext
): HomeComponent, ComponentContext by componentContext{
}