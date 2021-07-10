package com.example.listatarefas_app16

import androidx.room.*

@Entity(tableName = "TB_TAREFA")
data class Tarefa(
    @PrimaryKey(autoGenerate = true)
    var id: Int=0,
    @ColumnInfo(name="Nome")
    val nome: String,
)