package com.thuhale.thuhale_comp304_lab2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CheckoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        // Application Shared Preferences
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

        // Create variables
        val menuTypeRadioGroup: RadioGroup = findViewById(R.id.menuTypeRadioGroup)
        val totalPriceTextView: TextView = findViewById(R.id.totalPriceToBeCalculated)
        val layoutTotalPrice : LinearLayout = findViewById(R.id.totalPrice)
        val layoutDeliveryType: LinearLayout = findViewById(R.id.deliveryType)
        val divider : View = findViewById(R.id.divider1)
        val btnCheckout : Button = findViewById(R.id.btnCheckout)

        // Mapping items
        val items = mapOf(
            R.id.type1_name1_cb to Triple(getString(R.string.type1_name1), R.string.type1_info1, R.drawable.type1_bagel),
            R.id.type1_name2_cb to Triple(getString(R.string.type1_name2), R.string.type1_info2, R.drawable.type1_croissant),
            R.id.type1_name3_cb to Triple(getString(R.string.type1_name3), R.string.type1_info3, R.drawable.type1_scrambledegg),
            R.id.type1_name4_cb to Triple(getString(R.string.type1_name4), R.string.type1_info4, R.drawable.type1_parfait),
            R.id.type1_name5_cb to Triple(getString(R.string.type1_name5), R.string.type1_info5, R.drawable.type1_pancakes),
            R.id.type1_name6_cb to Triple(getString(R.string.type1_name6), R.string.type1_info6, R.drawable.type1_burrito),

            R.id.type2_name1_cb to Triple(getString(R.string.type2_name1), R.string.type2_info1, R.drawable.type2_blt),
            R.id.type2_name2_cb to Triple(getString(R.string.type2_name2), R.string.type2_info2, R.drawable.type2_turkey_club),
            R.id.type2_name3_cb to Triple(getString(R.string.type2_name3), R.string.type2_info3, R.drawable.type2_grilled_cheese),
            R.id.type2_name4_cb to Triple(getString(R.string.type2_name4), R.string.type2_info4, R.drawable.type2_ham_cheese),
            R.id.type2_name5_cb to Triple(getString(R.string.type2_name5), R.string.type2_info5, R.drawable.type2_chicken_sandwich),
            R.id.type2_name6_cb to Triple(getString(R.string.type2_name6), R.string.type2_info6, R.drawable.type2_tuna_melt),

            R.id.type3_name1_cb to Triple(getString(R.string.type3_name1), R.string.type3_info1, R.drawable.type3_caesar_wrap),
            R.id.type3_name2_cb to Triple(getString(R.string.type3_name2), R.string.type3_info2, R.drawable.type3_turkey_wrap),
            R.id.type3_name3_cb to Triple(getString(R.string.type3_name3), R.string.type3_info3, R.drawable.type3_veggie_wrap),
            R.id.type3_name4_cb to Triple(getString(R.string.type3_name4), R.string.type3_info4, R.drawable.type3_buffalo_wrap),
            R.id.type3_name5_cb to Triple(getString(R.string.type3_name5), R.string.type3_info5, R.drawable.type3_hummus_wrap),
            R.id.type3_name6_cb to Triple(getString(R.string.type3_name6), R.string.type3_info6, R.drawable.type3_steak_wrap),

            R.id.type4_name1_cb to Triple(getString(R.string.type4_name1), R.string.type4_info1, R.drawable.type4_coffee),
            R.id.type4_name2_cb to Triple(getString(R.string.type4_name2), R.string.type4_info2, R.drawable.type4_tea),
            R.id.type4_name3_cb to Triple(getString(R.string.type4_name3), R.string.type4_info3, R.drawable.type4_orange_juice),
            R.id.type4_name4_cb to Triple(getString(R.string.type4_name4), R.string.type4_info4, R.drawable.type4_smoothie),
            R.id.type4_name5_cb to Triple(getString(R.string.type4_name5), R.string.type4_info5, R.drawable.type4_soda),
            R.id.type4_name6_cb to Triple(getString(R.string.type4_name6), R.string.type4_info6, R.drawable.type4_water),

            R.id.type5_name1_cb to Triple(getString(R.string.type5_name1), R.string.type5_info1, R.drawable.type5_chocolate_cake),
            R.id.type5_name2_cb to Triple(getString(R.string.type5_name2), R.string.type5_info2, R.drawable.type5_ice_cream),
            R.id.type5_name3_cb to Triple(getString(R.string.type5_name3), R.string.type5_info3, R.drawable.type5_fruit_salad),
            R.id.type5_name4_cb to Triple(getString(R.string.type5_name4), R.string.type5_info4, R.drawable.type5_milkshake),
            R.id.type5_name5_cb to Triple(getString(R.string.type5_name5), R.string.type5_info5, R.drawable.type5_tiramisu),
            R.id.type5_name6_cb to Triple(getString(R.string.type5_name6), R.string.type5_info6, R.drawable.type5_cheesecake)
        )

        var itemAdded = false
        var totalPrice = 0.00

        // Adding chosen items into cart
        items.forEach { (id, value) ->
            if (sharedPreferences.getBoolean(id.toString(), false)) {
                val customView = LayoutInflater.from(this).inflate(R.layout.custom_radio_button, null)
                val itemNameRadioButton: RadioButton = customView.findViewById(R.id.itemName)
                val itemPriceTextView: TextView = customView.findViewById(R.id.itemPrice)
                val itemImageView: ImageView = customView.findViewById(R.id.itemImage)

                val itemName = value.first
                val itemPrice = getString(value.second)
                val itemImage = value.third

                itemNameRadioButton.text = itemName
                itemPriceTextView.text = itemPrice
                itemImageView.setImageResource(itemImage)

                // Extract price value from the string and add to total price
                val priceValue = itemPrice.replace("[^\\d.]".toRegex(), "").toDoubleOrNull() ?: 0.00
                totalPrice += priceValue

                val layoutParams = RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.MATCH_PARENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    bottomMargin = 30 // Adjust spacing
                }

                customView.layoutParams = layoutParams
                menuTypeRadioGroup.addView(customView)
                itemAdded = true
            }
        }

        // If no items are added, display the message and an image
        if (!itemAdded) {
            // Hide Total Price and Delivery Type if the cart is empty
            divider.visibility = View.GONE
            layoutDeliveryType.visibility = View.GONE
            layoutTotalPrice.visibility = View.GONE

            // Display image
            val emptyBasketImageView = ImageView(this).apply {
                setImageResource(R.drawable.empty_basket)
                layoutParams = RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.WRAP_CONTENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    topMargin = 20
                    width = 700
                    gravity = Gravity.CENTER_HORIZONTAL
                }
            }
            menuTypeRadioGroup.addView(emptyBasketImageView)

            // Display message on screen
            val emptyCartMessageTextView = TextView(this).apply {
                text = "Empty Cart"
                textSize = 30F
                setTextColor(resources.getColor(android.R.color.black, theme))
                layoutParams = RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.WRAP_CONTENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    gravity = Gravity.CENTER_HORIZONTAL
                }
            }
            menuTypeRadioGroup.addView(emptyCartMessageTextView)

            // Display message on screen
            val noItemsMessageTextView = TextView(this).apply {
                text = "Good food is always cooking! Go ahead, order some yummy food from the menu!"
                textSize = 20F
                setTextColor(resources.getColor(android.R.color.darker_gray, theme))
                layoutParams = RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.WRAP_CONTENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    topMargin = 20
                    gravity = Gravity.CENTER_HORIZONTAL
                }
            }
            menuTypeRadioGroup.addView(noItemsMessageTextView)
        } else {
            // Display the divider
            divider.visibility = View.VISIBLE
            // Display the delivery type
            layoutDeliveryType.visibility = View.VISIBLE
            // Display the total price
            layoutTotalPrice.visibility = View.VISIBLE
            totalPriceTextView.text = "$$totalPrice"
        }

        // Navigate to Payment Activity
        btnCheckout.setOnClickListener {
            if (!itemAdded) {
                Toast.makeText(this, "Please pick an item to check out!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, PaymentActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
