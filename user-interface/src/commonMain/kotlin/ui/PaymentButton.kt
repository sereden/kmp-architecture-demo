package ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun PaymentButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
)