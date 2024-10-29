package example.presentation.payment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.PaymentButton

@Composable
fun PaymentScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxSize()
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
                .padding(bottom = 32.dp)
        )
    }
}