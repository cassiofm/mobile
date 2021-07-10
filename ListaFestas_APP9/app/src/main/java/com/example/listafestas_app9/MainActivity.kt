package com.example.listafestas_app9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvFestas)
        val lista = mutableListOf<Festa>(
            Festa(dono="Marcos", nome="Rock and Rool", tema = "Anos 60",  foto=resources.getDrawable(R.drawable.party)),
            Festa(dono="Roberto", nome="BOOH", tema = "Hallowen",  foto=resources.getDrawable(R.drawable.party)),
            Festa(dono="Amanda", nome="Eletro House", tema = "Eletronica", foto=resources.getDrawable(R.drawable.party))
        )
        rv.adapter = FestaAdapter(lista)

        rv.layoutManager = LinearLayoutManager(this)
    }
}