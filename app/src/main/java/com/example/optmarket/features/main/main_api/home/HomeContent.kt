package com.example.optmarket.features.main.main_api.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.optmarket.R
import com.example.optmarket.ui.theme.AppColor
import com.example.optmarket.ui.theme.AppTheme

@Composable
fun HomeComponent(
    component: HomeComponent
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.Light.Background)
            .systemBarsPadding()
            .padding(16.dp)
    ) {
        HomeAppBar(
            title = "Opt Market",
            OnSettignsClicked = {}
        )
    }
}

@Composable
private fun HomeAppBar(
    title: String,
    OnSettignsClicked: () -> Unit,
) {
    Row(
        modifier = Modifier
            .height(57.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            color = AppColor.Light.OnBackground,
            style = AppTheme.typography.headlineLarge,
            modifier = Modifier.weight(1f)
        )
        IconButton(
            onClick = OnSettignsClicked
        ) {
            Icon(
                painter = painterResource(R.drawable.settings),
                contentDescription = "arrow",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}