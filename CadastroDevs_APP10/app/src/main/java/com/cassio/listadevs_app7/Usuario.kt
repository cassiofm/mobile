package com.cassio.listadevs_app7

import android.graphics.Bitmap
import android.graphics.drawable.Drawable

data class Usuario(
    var foto: Bitmap?=null,
    var nome: String,
    var email: String,
    var stack: Stack,
    var senioridade: Senioridade,
    var empregado: Boolean
)


