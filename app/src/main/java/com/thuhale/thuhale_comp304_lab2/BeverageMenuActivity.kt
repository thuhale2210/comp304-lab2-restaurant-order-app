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

class BeverageMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_beverage_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Adding buttons
        val btnContinue = findViewById<Button>(R.id.btnContinue)
        val btnCheckOut = findViewById<Button>(R.id.btnCheckOut)

        // Creating checkboxes for appropriate items
        val isCoffeeCb = findViewById<CheckBox>(R.id.type4_name1_cb)
        val isTeaCb = findViewById<CheckBox>(R.id.type4_name2_cb)
        val isOrangeJuiceCb = findViewById<CheckBox>(R.id.type4_name3_cb)
        val isSmoothieCb = findViewById<CheckBox>(R.id.type4_name4_cb)
        val isSodaCb = findViewById<CheckBox>(R.id.type4_name5_cb)
        val isWaterCb = findViewById<CheckBox>(R.id.type4_name6_cb)

        // Application Shared Preferences
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        // Save preferences and navigate to Menu Activity
        btnContinue.setOnClickListener {
            savePreferences(editor, isCoffeeCb, isTeaCb, isOrangeJuiceCb, isSmoothieCb, isSodaCb, isWaterCb)
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        // Save preferences and navigate to Checkout Activity
        btnCheckOut.setOnClickListener {
            savePreferences(editor, isCoffeeCb, isTeaCb, isOrangeJuiceCb, isSmoothieCb, isSodaCb, isWaterCb)
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