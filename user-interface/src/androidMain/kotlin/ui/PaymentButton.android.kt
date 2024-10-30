package ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.pay.button.ButtonTheme
import com.google.pay.button.ButtonType
import com.google.pay.button.PayButton

@Composable
actual fun PaymentButton(
    onClick: () -> Unit,
    modifier: Modifier
) {
    val googlePayHelper by remember { mutableStateOf(GooglePayHelper()) }

    PayButton(
        type = ButtonType.Plain,
        modifier = modifier.fillMaxWidth(),
        theme = if (isSystemInDarkTheme()) ButtonTheme.Light else ButtonTheme.Dark,
        onClick = {
            val paymentClient = googlePayHelper.createPaymentsClient(false)
            // TODO proceed with payment
        },
        allowedPaymentMethods = ""
    )
}