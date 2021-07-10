package com.example.cadastropets_app11

import android.graphics.Bitmap

data class Pet(
    var foto: Bitmap?=null,
    var nome: String,
    var dono: String,
    var tipo: Tipo,
)
