package com.cassio.shortbio_app6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SobreActivity : AppCompatActivity() {
    private lateinit var btnHome : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)

        btnHome = findViewById(R.id.btnHomeSobre)

        btnHome.setOnClickListener {
            val intent = Intent(this@SobreActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}