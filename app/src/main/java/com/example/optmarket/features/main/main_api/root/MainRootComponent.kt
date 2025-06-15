package com.example.optmarket.features.main.main_api.root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.example.optmarket.features.main.main_api.home.HomeComponent

interface MainRootComponent {
    val childStack: Value<ChildStack<*, Child>>

    sealed interface Child {
        class Home(val component: HomeComponent) : Child
    }
}