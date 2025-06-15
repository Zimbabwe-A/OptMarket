package com.example.optmarket.features.main.main_api.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.example.optmarket.features.main.main_api.home.HomeComponent

@Composable
fun MainRootContent(
    component: MainRootComponent
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Children(
            stack = component.childStack,
            modifier = Modifier.fillMaxSize(),
            animation = stackAnimation(fade())
        ) {
            when (val  child = it.instance) {
                is MainRootComponent.Child.Home -> HomeComponent(component = child.component)
            }
        }
    }
}