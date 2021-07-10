package com.example.listacompras_app15

import androidx.room.*

@Entity(tableName = "TB_ITEM")
data class Item(
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    @ColumnInfo(name="Nome")
    val nome: String,
)