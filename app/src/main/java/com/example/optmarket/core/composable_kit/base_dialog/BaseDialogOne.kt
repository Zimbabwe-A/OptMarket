package com.example.optmarket.core.composable_kit.base_dialog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.optmarket.R
import com.example.optmarket.ui.theme.AppColor
import com.example.optmarket.ui.theme.AppTheme

@Composable
fun BaseDialogOne(
    title: String,
    @DrawableRes icon: Int,
    message: String = "",
    onDismissRequest: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .width(295.dp)
                .background(AppColor.Light.Surface),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.height(34.dp))
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .background(AppColor.Light.negativeIconBg),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = "nbn",
                    modifier = Modifier.size(32.dp),
                    tint = AppColor.Light.negativeIcon
                )
            }
            Spacer(Modifier.height(20.dp))
            Text(
                text = title,
                style = AppTheme.typography.titleLarge,
                color = AppColor.Light.OnSurface,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(4.dp))
            if (message.isNotEmpty()) {
                Text(
                    text = message,
                    style = AppTheme.typography.bodyLarge,
                    color = AppColor.Light.OnSurface,
                    textAlign = TextAlign.Center,
                )
            }
            Spacer(Modifier.height(27.dp))
            HorizontalDivider(thickness = 2.dp)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clickable {
                        onDismissRequest()
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "ОК"
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewBaseDialogOne() {
    BaseDialogOne(
        title = "Ошибка почты",
        message = "Неверный формат \n электронной почты",
        icon = R.drawable.danger_circle,
        onDismissRequest = {},
    )
}


