package com.example.lab_week_02_c

import android.app.ComponentCaller
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class StandardActivity : AppCompatActivity() {
    companion object {
        private const val DEBUG = "DEBUG_STANDARD"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standard)
        Log.d(DEBUG, "onCreate StandardActivity")

        val buttonStandard = findViewById<Button>(R.id.button_standard)
        buttonStandard?.setOnClickListener {
            Log.d(DEBUG, "Tombol Standard Activity diklik")
            startActivity(Intent(this, StandardActivity::class.java))
        }
        if (buttonStandard == null) {
            Log.e(DEBUG, "Tombol R.id.button_standard tidak ditemukan di R.layout.activity_standard")
        }
    }

    // Penyesuaian fokus di sini untuk mengatasi kedua error secara bersamaan
    override fun onNewIntent(intent: Intent) {
        if (intent != null) {
            // Jika superclass benar-benar mengharapkan non-null, ini akan memenuhinya.
            // Jika superclass menerima nullable, ini juga valid.
            super.onNewIntent(intent)
        }
        // else {
        // Jika intent null, dan kita masih perlu memanggil super (jarang untuk onNewIntent),
        // kita bisa memanggilnya dengan Intent() baru jika itu akan memuaskan superclass
        // tanpa menyebabkan error. Namun, lebih aman untuk tidak memanggilnya jika intent null
        // kecuali ada dokumentasi yang spesifik mengharuskan.
        // Untuk sekarang, kita hanya memanggil super jika intent tidak null.
        // Jika 'overrides nothing' tetap ada, masalahnya bukan di panggilan super ini.
        // }
        Log.d(DEBUG, "onNewIntent StandardActivity. Data: ${intent?.dataString}")
    }
}
