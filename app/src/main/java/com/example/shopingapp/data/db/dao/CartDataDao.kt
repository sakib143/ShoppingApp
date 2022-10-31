package com.example.shopingapp.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.shopingapp.data.db.table.CartData


@Dao
interface CartDataDao {
    @Query("SELECT * FROM momin_data  ORDER BY id ASC")
    fun getAllCartItemData(): List<CartData>

    @Query("INSERT INTO momin_data (itemId,name,brandname,minimumQty,rate,imageUrl)" +
            " VALUES (:itemId,:name,:brandname,:minimumQty,:rate,:imageUrl)")
    fun addToCart(
        itemId:Int,
        name:String,
        brandname:String,
        minimumQty:String,
        rate:String,
        imageUrl:String)

    @Query("DELETE  FROM momin_data WHERE id = :id")
    fun deleteMominData(id: Int)

}