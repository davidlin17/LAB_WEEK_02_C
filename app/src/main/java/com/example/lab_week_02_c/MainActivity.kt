package com.example.lab_week_02_c

import android.content.Intent // Impor untuk Intent
import android.os.Bundle
import android.util.Log // Impor untuk Log
import android.view.View // Impor untuk View.OnClickListener
import android.widget.Button // Impor untuk Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        private const val DEBUG = "DEBUG_MAIN"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        Log.d(DEBUG, "onCreate MainActivity")

        val buttonClickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.button_standard -> {
                    Log.d(DEBUG, "Tombol Standard di MainActivity diklik")
                    startActivity(
                        Intent(this, StandardActivity::class.java)
                    )
                }
                R.id.button_single_top -> {
                    Log.d(DEBUG, "Tombol SingleTop di MainActivity diklik")
                    startActivity(
                        Intent(this, SingleTopActivity::class.java)
                    )
                }
            }
        }

        val buttonStandard = findViewById<Button>(R.id.button_standard)
        val buttonSingleTop = findViewById<Button>(R.id.button_single_top)

        buttonStandard?.setOnClickListener(buttonClickListener)
        buttonSingleTop?.setOnClickListener(buttonClickListener)

        if (buttonStandard == null) {
            Log.e(DEBUG, "Tombol dengan ID 'button_standard' tidak ditemukan di R.layout.activity_main")
        }
        if (buttonSingleTop == null) {
            Log.e(DEBUG, "Tombol dengan ID 'button_single_top' tidak ditemukan di R.layout.activity_main")
        }
    }
}

