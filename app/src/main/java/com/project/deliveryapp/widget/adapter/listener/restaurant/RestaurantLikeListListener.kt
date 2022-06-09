package com.project.deliveryapp.widget.adapter.listener.restaurant

import com.project.deliveryapp.model.restaurant.RestaurantModel

interface RestaurantLikeListListener: RestaurantListListener {

    fun onDislikeItem(model: RestaurantModel)

}