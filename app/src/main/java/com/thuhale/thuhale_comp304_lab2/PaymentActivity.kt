package com.thuhale.thuhale_comp304_lab2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        // Initialize views
        val paymentMethodRadioGroup: RadioGroup = findViewById(R.id.paymentMethodRadioGroup)
        val btnPayment: Button = findViewById(R.id.btnPayment)

        // Set click listener for the proceed button
        btnPayment.setOnClickListener {
            // Get the selected payment method
            val selectedPaymentMethodId = paymentMethodRadioGroup.checkedRadioButtonId
            val selectedPaymentMethod: String = findViewById<RadioButton>(selectedPaymentMethodId).text.toString()

            // Redirect to the appropriate activity based on the selected payment method
            when (selectedPaymentMethod) {
                getString(R.string.methodCash) -> {
                    // Handle cash payment
                    val intent = Intent(this, OrderCompleteActivity::class.java)
                    startActivity(intent)
                }
                getString(R.string.methodCredit) -> {
                    // Handle credit card payment
                    val intent = Intent(this, PaymentInfoActivity::class.java)
                    startActivity(intent)
                }
                getString(R.string.methodDebit) -> {
                    // Handle debit card payment
                    val intent = Intent(this, PaymentInfoActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
