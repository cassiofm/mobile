package com.example.listacompras_app15

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Item::class), version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun itemDao():ItemDAO

}
