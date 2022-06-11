package com.project.deliveryapp.widget.adapter.listener.order

import com.project.deliveryapp.widget.adapter.listener.AdapterListener

interface OrderListListener: AdapterListener {

    fun writeRestaurantReview(orderId: String, restaurantTitle: String)

}