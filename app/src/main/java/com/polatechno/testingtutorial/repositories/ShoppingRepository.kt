package com.polatechno.testingtutorial.repositories

import androidx.lifecycle.LiveData
import com.polatechno.testingtutorial.data.local.ShoppingItem
import com.polatechno.testingtutorial.data.remote.responses.ImageResponse
import com.polatechno.testingtutorial.other.Resource

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItem(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>
}