package com.cassio.shortbio_app6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ExperienciaActivity : AppCompatActivity() {
    private lateinit var btnHome : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experiencia)

        btnHome = findViewById(R.id.btnHomeExperiencia)

        btnHome.setOnClickListener {
            val intent = Intent(this@ExperienciaActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}