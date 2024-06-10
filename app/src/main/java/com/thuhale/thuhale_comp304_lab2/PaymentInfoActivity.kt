package com.thuhale.thuhale_comp304_lab2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PaymentInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payment_info)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            // Retrieve EditText views
            val fullNameEditText = findViewById<EditText>(R.id.fullNameEditText)
            val addressEditText = findViewById<EditText>(R.id.addressEditText)
            val phoneNumberEditText = findViewById<EditText>(R.id.phoneNumberEditText)
            val cardNumberEditText = findViewById<EditText>(R.id.cardNumberEditText)
            val expiryDateEditText = findViewById<EditText>(R.id.expiryDateEditText)
            val cvvEditText = findViewById<EditText>(R.id.cvvEditText)
            val favoriteTeamEditText = findViewById<EditText>(R.id.favoriteTeamEditText)
            val favoriteShowEditText = findViewById<EditText>(R.id.favoriteShowEditText)

            // Validate entries
            if (validateFullName(fullNameEditText.text.toString()) &&
                validateAddress(addressEditText.text.toString()) &&
                validatePhoneNumber(phoneNumberEditText.text.toString()) &&
                validateCardNumber(cardNumberEditText.text.toString()) &&
                validateExpiryDate(expiryDateEditText.text.toString()) &&
                validateCVV(cvvEditText.text.toString()) &&
                validateCustomField(favoriteTeamEditText.text.toString()) &&
                validateCustomField(favoriteShowEditText.text.toString())
            ) {
                // All entries are valid, proceed with submission
                Toast.makeText(this, "Submission successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, OrderCompleteActivity::class.java)
                startActivity(intent)
            } else {
                // Validation failed, display error message
                Toast.makeText(this, "Please enter valid information", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Validation functions for each field
    private fun validateFullName(fullName: String): Boolean {
        // Implement your validation logic for full name
        return fullName.isNotBlank() // Example: Require non-empty full name
    }

    private fun validateAddress(address: String): Boolean {
        // Implement your validation logic for address
        return address.isNotBlank() // Example: Require non-empty address
    }

    private fun validatePhoneNumber(phoneNumber: String): Boolean {
        // Implement your validation logic for phone number
        return phoneNumber.isNotBlank() // Example: Require non-empty phone number
    }

    private fun validateCardNumber(cardNumber: String): Boolean {
        // Implement your validation logic for card number
        return cardNumber.isNotBlank() // Example: Require non-empty card number
    }

    private fun validateExpiryDate(expiryDate: String): Boolean {
        // Implement your validation logic for expiry date
        return expiryDate.isNotBlank() // Example: Require non-empty expiry date
    }

    private fun validateCVV(cvv: String): Boolean {
        // Implement your validation logic for CVV
        return cvv.isNotBlank() // Example: Require non-empty CVV
    }

    private fun validateCustomField(customField: String): Boolean {
        // Implement your validation logic for custom fields
        return customField.isNotBlank() // Example: Require non-empty custom field
    }
}
