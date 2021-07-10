package com.example.listapets_app8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvPets)
        val lista = mutableListOf<Pet>(
            Pet(dono="Larissa", nome="Bolinha de neve", tipo = "Gato",  foto=resources.getDrawable(R.drawable.ic_launcher_background)),
            Pet(dono="Maurício", nome="Mozart", tipo = "Cachorro",  foto=resources.getDrawable(R.drawable.dog)),
            Pet(dono="Maria", nome="Rex", tipo = "Passáro", foto=resources.getDrawable(R.drawable.passaro))
        )
        rv.adapter = PetAdapter(lista)

        rv.layoutManager = LinearLayoutManager(this)
    }
}