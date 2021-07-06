package com.cassio.shortbio_app6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ObjetivoActivity : AppCompatActivity() {
    private lateinit var btnHome : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_objetivo)

        btnHome = findViewById(R.id.btnHomeObjetivo)

        btnHome.setOnClickListener {
            val intent = Intent(this@ObjetivoActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}