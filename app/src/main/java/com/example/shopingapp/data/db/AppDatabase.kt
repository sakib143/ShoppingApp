package com.example.shopingapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shopingapp.data.db.dao.CartDataDao
import com.example.shopingapp.data.db.table.CartData

@Database(entities =
    arrayOf(
    CartData::class
    ),
    version = 2,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun mominDataDao(): CartDataDao

}