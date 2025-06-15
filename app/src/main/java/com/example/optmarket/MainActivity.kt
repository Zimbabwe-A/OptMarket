package com.example.optmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import com.arkivanov.decompose.defaultComponentContext
import com.example.optmarket.features.root.api.RootComponent
import com.example.optmarket.features.root.impl.DefaultRootComponent
import com.example.optmarket.ui.theme.OptMarketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OptMarketTheme(
                darkTheme = false
            ) {
                var root = remember {
                    DefaultRootComponent(
                        componentContext = defaultComponentContext()
                    )
                }

                RootComponent(
                    component = root
                )
            }
        }
    }
}