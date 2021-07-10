package com.example.listapets_app8

import android.graphics.drawable.Drawable

data class Pet(
    var foto: Drawable?=null,
    var nome: String,
    var dono: String,
    var tipo: String
)