package com.example.optmarket.core.composable_kit.app_bar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.optmarket.R
import com.example.optmarket.ui.theme.AppColor
import com.example.optmarket.ui.theme.AppTheme

@Composable
fun AppBar(
    title: String,
    onBackClicked: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onBackClicked,
            modifier = Modifier.size(24.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.arrow_left),
                contentDescription = "ArrowBack",
                tint = AppTheme.colors.icon,
            )
        }
        Box(
            modifier = Modifier.weight(1f).height(57.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                style = AppTheme.typography.headlineLarge,
                color = AppColor.Light.OnBackground,
            )
        }
        Spacer(
            modifier = Modifier.width(28.dp)
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PrevAppBar() {
    AppBar(
        title = "Вход",
        onBackClicked = {}
    )
}