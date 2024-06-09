package com.thuhale.thuhale_comp304_lab2

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class InitialState : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeDefaultPreferences()
    }

    private fun initializeDefaultPreferences() {
        val sharedPreferences: SharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Define default items and their initial checked state (false)
        val defaultItems = listOf(
            R.id.type1_name1_cb,
            R.id.type1_name2_cb,
            R.id.type1_name3_cb,
            R.id.type1_name4_cb,
            R.id.type1_name5_cb,
            R.id.type1_name6_cb,
            R.id.type2_name1_cb,
            R.id.type2_name2_cb,
            R.id.type2_name3_cb,
            R.id.type2_name4_cb,
            R.id.type2_name5_cb,
            R.id.type2_name6_cb,
            R.id.type3_name1_cb,
            R.id.type3_name2_cb,
            R.id.type3_name3_cb,
            R.id.type3_name4_cb,
            R.id.type3_name5_cb,
            R.id.type3_name6_cb,
            R.id.type4_name1_cb,
            R.id.type4_name2_cb,
            R.id.type4_name3_cb,
            R.id.type4_name4_cb,
            R.id.type4_name5_cb,
            R.id.type4_name6_cb,
            R.id.type5_name1_cb,
            R.id.type5_name2_cb,
            R.id.type5_name3_cb,
            R.id.type5_name4_cb,
            R.id.type5_name5_cb,
            R.id.type5_name6_cb
        )

        // Check if preferences are already set
        val isInitialized = sharedPreferences.getBoolean("isInitialized", false)
        if (!isInitialized) {
            defaultItems.forEach { id ->
                editor.putBoolean(id.toString(), false)
            }
            editor.putBoolean("isInitialized", true) // Mark preferences as initialized
            editor.apply()
        }
        else {
            editor.clear().apply()
        }
    }
}
