package com.project.deliveryapp.widget.adapter.listener.restaurant

import com.project.deliveryapp.model.restaurant.RestaurantModel
import com.project.deliveryapp.widget.adapter.listener.AdapterListener

interface RestaurantListListener: AdapterListener {

    fun onClickItem(model: RestaurantModel) {

    }

}