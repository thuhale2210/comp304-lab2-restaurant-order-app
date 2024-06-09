package com.thuhale.thuhale_comp304_lab2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DessertMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dessert_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Adding buttons
        val btnContinue = findViewById<Button>(R.id.btnContinue)
        val btnCheckOut = findViewById<Button>(R.id.btnCheckOut)

        // Creating checkboxes for appropriate items
        val isChocoCakeCb = findViewById<CheckBox>(R.id.type5_name1_cb)
        val isIceCreamCb = findViewById<CheckBox>(R.id.type5_name2_cb)
        val isFruitSaladCb = findViewById<CheckBox>(R.id.type5_name3_cb)
        val isMilkShakeCb = findViewById<CheckBox>(R.id.type5_name4_cb)
        val isTiramisuCb = findViewById<CheckBox>(R.id.type5_name5_cb)
        val isCheeseCakeCb = findViewById<CheckBox>(R.id.type5_name6_cb)

        // Application Shared Preferences
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        // Save preferences and navigate to Menu Activity
        btnContinue.setOnClickListener {
            savePreferences(editor, isChocoCakeCb, isIceCreamCb, isFruitSaladCb, isMilkShakeCb, isTiramisuCb, isCheeseCakeCb)
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        // Save preferences and navigate to Checkout Activity
        btnCheckOut.setOnClickListener {
            savePreferences(editor, isChocoCakeCb, isIceCreamCb, isFruitSaladCb, isMilkShakeCb, isTiramisuCb, isCheeseCakeCb)
            val intent = Intent(this, CheckoutActivity::class.java)
            startActivity(intent)
        }
    }

    private fun savePreferences(editor: SharedPreferences.Editor, vararg checkBoxes: CheckBox) {
        checkBoxes.forEach { checkBox ->
            editor.putBoolean(checkBox.id.toString(), checkBox.isChecked)
        }
        editor.apply()
    }
}