package ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.ObjCAction
import platform.Foundation.NSSelectorFromString
import platform.PassKit.PKPaymentButton
import androidx.compose.ui.viewinterop.UIKitView
import platform.PassKit.PKPaymentButtonStyleBlack
import platform.PassKit.PKPaymentButtonStyleWhite
import platform.PassKit.PKPaymentButtonTypePlain
import platform.UIKit.UIControlEventTouchUpInside

@OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
@Composable
actual fun PaymentButton(
    onClick: () -> Unit,
    modifier: Modifier
) {
    val isDarkMode = isSystemInDarkTheme()
    UIKitView(
        factory = {
            val button = object : PKPaymentButton(
                paymentButtonType = PKPaymentButtonTypePlain,
                paymentButtonStyle = if (isDarkMode) PKPaymentButtonStyleWhite else PKPaymentButtonStyleBlack
            ) {
                // Object + @ObjC annotation are required to make button clickable
                @ObjCAction
                fun payAction() {
                    // TODO implement payment click
                }
            }
            button.setCornerRadius(100.0)
            button.addTarget(
                target = button,
                action = NSSelectorFromString(button::payAction.name),
                forControlEvents = UIControlEventTouchUpInside
            )
            button
        },
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(32.dp))
    )
}