package com.thuhale.thuhale_comp304_lab2

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class CheckoutActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        // Application Shared Preferences
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

        // Display selected menu items
        val selectedItemsTextView: TextView = findViewById(R.id.selectedItemsTextView)

        val items = mapOf(
            R.id.type1_name1_cb to Pair(getString(R.string.type1_name1), R.string.type1_info1),
            R.id.type1_name2_cb to Pair(getString(R.string.type1_name2), R.string.type1_info2),
            R.id.type1_name3_cb to Pair(getString(R.string.type1_name3), R.string.type1_info3),
            R.id.type1_name4_cb to Pair(getString(R.string.type1_name4), R.string.type1_info4),
            R.id.type1_name5_cb to Pair(getString(R.string.type1_name5), R.string.type1_info5),
            R.id.type1_name6_cb to Pair(getString(R.string.type1_name6), R.string.type1_info6),

            R.id.type2_name1_cb to Pair(getString(R.string.type2_name1), R.string.type2_info1),
            R.id.type2_name2_cb to Pair(getString(R.string.type2_name2), R.string.type2_info2),
            R.id.type2_name3_cb to Pair(getString(R.string.type2_name3), R.string.type2_info3),
            R.id.type2_name4_cb to Pair(getString(R.string.type2_name4), R.string.type2_info4),
            R.id.type2_name5_cb to Pair(getString(R.string.type2_name5), R.string.type2_info5),
            R.id.type2_name6_cb to Pair(getString(R.string.type2_name6), R.string.type2_info6),

            R.id.type3_name1_cb to Pair(getString(R.string.type3_name1), R.string.type3_info1),
            R.id.type3_name2_cb to Pair(getString(R.string.type3_name2), R.string.type3_info2),
            R.id.type3_name3_cb to Pair(getString(R.string.type3_name3), R.string.type3_info3),
            R.id.type3_name4_cb to Pair(getString(R.string.type3_name4), R.string.type3_info4),
            R.id.type3_name5_cb to Pair(getString(R.string.type3_name5), R.string.type3_info5),
            R.id.type3_name6_cb to Pair(getString(R.string.type3_name6), R.string.type3_info6),

            R.id.type4_name1_cb to Pair(getString(R.string.type4_name1), R.string.type4_info1),
            R.id.type4_name2_cb to Pair(getString(R.string.type4_name2), R.string.type4_info2),
            R.id.type4_name3_cb to Pair(getString(R.string.type4_name3), R.string.type4_info3),
            R.id.type4_name4_cb to Pair(getString(R.string.type4_name4), R.string.type4_info4),
            R.id.type4_name5_cb to Pair(getString(R.string.type4_name5), R.string.type4_info5),
            R.id.type4_name6_cb to Pair(getString(R.string.type4_name6), R.string.type4_info6),

            R.id.type5_name1_cb to Pair(getString(R.string.type5_name1), R.string.type5_info1),
            R.id.type5_name2_cb to Pair(getString(R.string.type5_name2), R.string.type5_info2),
            R.id.type5_name3_cb to Pair(getString(R.string.type5_name3), R.string.type5_info3),
            R.id.type5_name4_cb to Pair(getString(R.string.type5_name4), R.string.type5_info4),
            R.id.type5_name5_cb to Pair(getString(R.string.type5_name5), R.string.type5_info5),
            R.id.type5_name6_cb to Pair(getString(R.string.type5_name6), R.string.type5_info6)
        )

        // Radio group for selecting menu types
        val menuTypeRadioGroup: RadioGroup = findViewById(R.id.menuTypeRadioGroup)
        var itemAdded = false

        items.forEach { (id, value) ->
            if (sharedPreferences.getBoolean(id.toString(), false)) {
                val radioButton = RadioButton(this)
                val itemName = value.first
                val itemPrice = getString(value.second)
                radioButton.text = "$itemName: $itemPrice"
                radioButton.textSize = 20F

                // Set margin between RadioButtons
                val layoutParams = RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.WRAP_CONTENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    bottomMargin = 16 // Change this value to adjust spacing
                }
                radioButton.layoutParams = layoutParams

                menuTypeRadioGroup.addView(radioButton)
                itemAdded = true
            }
        }

        // If no items are added, display the message
        if (!itemAdded) {
            val noItemsTextView = TextView(this).apply {
                text = "You don't have any items in cart"
                textSize = 20F
                setTextColor(resources.getColor(android.R.color.darker_gray, theme))
                layoutParams = RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.WRAP_CONTENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    topMargin = 20
                }
            }
            menuTypeRadioGroup.addView(noItemsTextView)
        }

    }
}
