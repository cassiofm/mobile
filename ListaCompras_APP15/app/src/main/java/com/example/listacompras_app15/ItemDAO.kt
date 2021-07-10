package com.example.listacompras_app15

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDAO {
    @Query("SELECT * FROM TB_ITEM")
    suspend fun getItems(): List<Item>

    @Insert
    suspend fun addItems(t: Item)

    @Delete
    suspend fun deleteItem(t: Item)
}