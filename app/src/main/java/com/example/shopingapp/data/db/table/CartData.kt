package com.example.shopingapp.data.db.table

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "momin_data")
data class CartData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "itemId")
    val itemId: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "brandname")
    val brandname: String,
    @ColumnInfo(name = "minimumQty")
    val minimumQty: String,
    @ColumnInfo(name = "rate")
    val rate: String,
    @ColumnInfo(name = "imageUrl")
    val imageUrl: String
)