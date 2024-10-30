package ui

import android.content.Context
import com.google.android.gms.tasks.Task
import com.google.android.gms.wallet.PaymentData
import com.google.android.gms.wallet.PaymentDataRequest
import com.google.android.gms.wallet.PaymentsClient
import com.google.android.gms.wallet.Wallet
import com.google.android.gms.wallet.WalletConstants
import org.json.JSONArray
import org.json.JSONObject
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GooglePayHelper : KoinComponent {

    private val context: Context by inject()

    fun createPaymentsClient(isProductionEnv: Boolean): PaymentsClient {
        val walletOptions = Wallet.WalletOptions.Builder()
            .setEnvironment(
                if (isProductionEnv) {
                    WalletConstants.ENVIRONMENT_PRODUCTION
                } else {
                    WalletConstants.ENVIRONMENT_TEST
                }
            )
            .build()

        return Wallet.getPaymentsClient(context, walletOptions)
    }

    private fun getLoadPaymentDataTask(
        price: String,
        currency: String,
        label: String,
        gateway: String,
        paymentGatewayMerchantId: String,
        isProductionEnv: Boolean
    ): Task<PaymentData> {
        val paymentDataRequestJson = getPaymentDataRequest(
            price = price,
            currency = currency,
            gateway = gateway,
            gatewayMerchantId = paymentGatewayMerchantId,
            label = label
        )
        val request = PaymentDataRequest.fromJson(paymentDataRequestJson.toString())
        return createPaymentsClient(isProductionEnv).loadPaymentData(request)
    }

    private fun getPaymentDataRequest(
        price: String,
        currency: String,
        gateway: String,
        gatewayMerchantId: String,
        label: String
    ): JSONObject {
        return JSONObject()
            .put("apiVersion", 2)
            .put("apiVersionMinor", 0)
            .put("allowedPaymentMethods", allowedPaymentMethods(gateway, gatewayMerchantId))
            .put("transactionInfo", getTransactionInfo(price, currency))
            .put("merchantInfo", JSONObject().put("merchantName", label))
            .put("shippingAddressRequired", true)
            .put(
                "shippingAddressParameters", JSONObject()
                    .put("phoneNumberRequired", false)
                    .put("allowedCountryCodes", JSONArray(listOf("US", "GB", "UA")))
            )
    }

    private fun allowedPaymentMethods(gateway: String, gatewayMerchantId: String): JSONArray? {
        return JSONArray().put(cardPaymentMethod(gateway, gatewayMerchantId))
    }

    private fun cardPaymentMethod(gateway: String, gatewayMerchantId: String): JSONObject {
        return baseCardPaymentMethod()
            .put("tokenizationSpecification", gatewayTokenizationSpecification(gateway, gatewayMerchantId))
    }

    private fun gatewayTokenizationSpecification(gateway: String, gatewayMerchantId: String) =
        JSONObject()
            .put("type", "PAYMENT_GATEWAY")
            .put(
                "parameters", JSONObject(
                    mapOf(
                        "gateway" to gateway,
                        "gatewayMerchantId" to gatewayMerchantId
                    )
                )
            )

    private fun baseCardPaymentMethod(): JSONObject =
        JSONObject()
            .put("type", "CARD")
            .put(
                "parameters", JSONObject()
                    .put("allowedAuthMethods", listOf("PAN_ONLY"))
                    .put("allowedCardNetworks", listOf("MASTERCARD", "VISA"))
                    .put("billingAddressRequired", true)
                    .put(
                        "billingAddressParameters", JSONObject()
                            .put("format", "FULL")
                    )
            )

    private fun getTransactionInfo(price: String, currency: String): JSONObject {
        return JSONObject()
            .put("totalPrice", price)
            .put("totalPriceStatus", "FINAL")
            .put("countryCode", "UA")
            .put("currencyCode", currency)
    }
}
