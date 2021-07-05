package com.cassio.sorteio_refatorado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var resultaSorteio: TextView
    lateinit var botaoSortear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultaSorteio = findViewById(R.id.textResultado)
        botaoSortear = findViewById(R.id.buttonSortear)

        botaoSortear.setOnClickListener {
            SortearNumero()
        }
    }

    fun SortearNumero() {
        var numeroSorteado = Random().nextInt(11)

        resultaSorteio.text = "O número é: $numeroSorteado"
    }
}
