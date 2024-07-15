package com.polatechno.testingtutorial.repositories

import androidx.lifecycle.LiveData
import com.polatechno.testingtutorial.data.local.ShoppingDao
import com.polatechno.testingtutorial.data.local.ShoppingItem
import com.polatechno.testingtutorial.data.remote.PixabayAPI
import com.polatechno.testingtutorial.data.remote.responses.ImageResponse
import com.polatechno.testingtutorial.other.Resource
import javax.inject.Inject

class DefaultShoppingRepository @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val pixabayAPI: PixabayAPI
) : ShoppingRepository {

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override fun observeAllShoppingItem(): LiveData<List<ShoppingItem>> {
        return shoppingDao.observeAllShoppingItems()
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return shoppingDao.observeTotalPrice()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return try {
            val response = pixabayAPI.searchForImage(imageQuery)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("An unknown error occurrec", null)
            } else {
                Resource.error("An unknown error occurrec", null)
            }

        } catch (e: Exception) {
            Resource.error("Couln't reach the server. Check your internet connection...", null)
        }
    }
}