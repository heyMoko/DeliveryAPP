package com.project.deliveryapp.data.repository.restaurant

import com.project.deliveryapp.data.entity.RestaurantEntity
import com.project.deliveryapp.screen.main.home.restaurant.RestaurantCategory

interface RestaurantRepository {

    suspend fun getList(
        restaurantCategory: RestaurantCategory,
    ): List<RestaurantEntity>

}