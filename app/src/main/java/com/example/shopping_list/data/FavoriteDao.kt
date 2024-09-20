package com.example.shopping_list.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorites(favoriteProduct: FavoriteProduct)

    @Query("SELECT * FROM favorites")
    fun getFavoriteProducts(): LiveData<List<FavoriteProduct>>

    @Delete
    suspend fun removeFromFavorites(favoriteProduct: FavoriteProduct)

    @Query("DELETE FROM favorites WHERE id = :productId")
    suspend fun removeFromFavoritesById(productId: Int)

    @Query("SELECT COUNT(*) > 0 FROM favorites WHERE id = :productId")
    suspend fun isProductFavorite(productId: Int): Boolean
}