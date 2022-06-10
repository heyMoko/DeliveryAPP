package com.project.deliveryapp.widget.adapter.listener.order

import com.project.deliveryapp.model.restaurant.food.FoodModel
import com.project.deliveryapp.widget.adapter.listener.AdapterListener

interface OrderMenuListListener: AdapterListener {

    fun onRemoveItem(model: FoodModel)

}