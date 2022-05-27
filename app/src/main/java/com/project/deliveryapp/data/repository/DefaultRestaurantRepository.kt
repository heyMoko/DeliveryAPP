package com.project.deliveryapp.data.repository

import android.content.res.loader.ResourcesProvider
import com.project.deliveryapp.data.entity.RestaurantEntity
import com.project.deliveryapp.screen.main.home.restaurant.RestaurantCategory
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DefaultRestaurantRepository(
    private val resourceProvider: ResourcesProvider,
    private val ioDispatcher: CoroutineDispatcher
): RestaurantRepository {

    override suspend fun getList(
        restaurantCategory: RestaurantCategory
    ): List<RestaurantEntity> = withContext(ioDispatcher) {

        // TODO API를 통한 데이터 받아오기
        listOf(
            
        )
    }
}