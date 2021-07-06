package com.cassio.shortbio_app6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btnSobre : Button
    private lateinit var btnFormacao : Button
    private lateinit var btnExperiencia : Button
    private lateinit var btnObjetivo : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSobre = findViewById(R.id.btnSobre)
        btnFormacao = findViewById(R.id.btnFormacao)
        btnExperiencia = findViewById(R.id.btnExperiencia)
        btnObjetivo = findViewById(R.id.btnObjetivo)

        btnSobre.setOnClickListener {
            val intent = Intent(this@MainActivity, SobreActivity::class.java)
            startActivity(intent)
        }

        btnFormacao.setOnClickListener {
            val intent = Intent(this@MainActivity, FormacaoActivity::class.java)
            startActivity(intent)
        }

        btnExperiencia.setOnClickListener {
            val intent = Intent(this@MainActivity, ExperienciaActivity::class.java)
            startActivity(intent)
        }

        btnObjetivo.setOnClickListener {
            val intent = Intent(this@MainActivity, ObjetivoActivity::class.java)
            startActivity(intent)
        }
    }
}