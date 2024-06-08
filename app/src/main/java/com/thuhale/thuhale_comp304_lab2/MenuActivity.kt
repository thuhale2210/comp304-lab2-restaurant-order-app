package com.thuhale.thuhale_comp304_lab2

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Adding menu to the main screen
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.file,menu)
        return true
    }

    // Event handler for selecting menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.menuType1 -> startActivity(Intent(this, BreakfastMenuActivity::class.java))
            R.id.menuType2 -> startActivity(Intent(this, SandwichMenuActivity::class.java))
            R.id.menuType3 -> startActivity(Intent(this, WrapsMenuActivity::class.java))
            R.id.menuType4 -> startActivity(Intent(this, BeverageMenuActivity::class.java))
            R.id.menuType5 -> startActivity(Intent(this, DessertMenuActivity::class.java))
        }
        return true
    }
}