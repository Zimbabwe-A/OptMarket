package com.example.optmarket.core.composable_kit.app_button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.optmarket.ui.theme.AppColor

@Composable
fun AppButton(
    title: String,
    onClick: () -> Unit,
    buttonType: ButtonType = ButtonType.Primary
) {

    val backgroundColor = when (buttonType) {
        ButtonType.Primary -> AppColor.Light.Primary
        ButtonType.Secondary -> AppColor.Light.Secondary
        ButtonType.Error -> AppColor.Light.OnPrimary
    }

    val contentColor = when (buttonType) {
        ButtonType.Primary -> AppColor.Light.OnPrimary
        ButtonType.Secondary -> AppColor.Light.OnSecondary
        ButtonType.Error -> AppColor.Light.Error
    }

    val onClickBoolean = when (buttonType) {
        ButtonType.Primary -> true
        ButtonType.Secondary -> true
        ButtonType.Error -> false
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .clickable(onClickBoolean) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            color = contentColor,
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}

enum class ButtonType {
    Primary,
    Secondary,
    Error
}

@Preview(showBackground = true)
@Composable
fun PrimaryAppButton() {
    AppButton(
        title = "Войти",
        onClick = {},
        buttonType = ButtonType.Primary
    )
}

@Preview(showBackground = true)
@Composable
fun SecondaryAppButton() {
    AppButton(
        title = "Войти",
        onClick = {},
        buttonType = ButtonType.Secondary
    )
}

@Preview(showBackground = true)
@Composable
fun ErrorAppButton() {
    AppButton(
        title = "Войти",
        onClick = {},
        buttonType = ButtonType.Error
    )
}
