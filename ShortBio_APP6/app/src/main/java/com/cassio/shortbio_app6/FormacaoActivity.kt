package com.cassio.shortbio_app6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FormacaoActivity : AppCompatActivity() {
    private lateinit var btnHome : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formacao)

        btnHome = findViewById(R.id.btnHomeFormacao)

        btnHome.setOnClickListener {
            val intent = Intent(this@FormacaoActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}