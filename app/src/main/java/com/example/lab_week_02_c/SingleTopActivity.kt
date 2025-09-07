package com.example.lab_week_02_c

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SingleTopActivity : AppCompatActivity() {
    companion object{
        private const val DEBUG = "DEBUG_SINGLE_TOP"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_top)
        Log.d(DEBUG, "onCreate SingleTopActivity")

        val buttonSingleTop = findViewById<Button>(R.id.button_single_top)
        buttonSingleTop?.setOnClickListener {
            Log.d(DEBUG, "Tombol di SingleTopActivity diklik")
            startActivity(Intent(this, SingleTopActivity::class.java))
        }
        if (buttonSingleTop == null) {
            Log.e(DEBUG, "Tombol R.id.button_single_top tidak ditemukan di R.layout.activity_single_top")
        }
    }

    // Penyesuaian fokus di sini untuk mengatasi kedua error secara bersamaan
    override fun onNewIntent(intent: Intent) {
        if (intent != null) {
            // Jika superclass benar-benar mengharapkan non-null, ini akan memenuhinya.
            // Jika superclass menerima nullable, ini juga valid.
            super.onNewIntent(intent)
        } else {
            Log.e(DEBUG, "Intent yang diterima oleh onNewIntent SingleTopActivity adalah null")
        }
        Log.d(DEBUG, "onNewIntent SingleTopActivity. Data: ${intent?.dataString}")
    }
}
