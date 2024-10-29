package example.presentation.payment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.PaymentButton

@Composable
fun PaymentScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize().statusBarsPadding()
        ) {
            Text(
                text = "Payment Data",
                style = MaterialTheme.typography.headlineLarge
            )
            Text(
                "Total: $34.99",
                style = MaterialTheme.typography.titleSmall
            )
        }

        PaymentButton(
            onClick = {
                // TODO implement
            },
            modifier = Modifier
                .navigationBarsPadding()
                .widthIn(720.dp)
                .padding(32.dp)
                .align(Alignment.BottomCenter)
        )
    }
}