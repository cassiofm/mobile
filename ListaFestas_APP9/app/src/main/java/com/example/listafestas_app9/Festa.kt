package com.example.listafestas_app9

import android.graphics.drawable.Drawable

data class Festa(
    var foto: Drawable?=null,
    var nome: String,
    var dono: String,
    var tema: String
)