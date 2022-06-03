package com.project.deliveryapp.widget.adapter.listener.restaurant

import com.project.deliveryapp.model.restaurant.food.FoodModel
import com.project.deliveryapp.widget.adapter.listener.AdapterListener

interface FoodMenuListListener: AdapterListener {

    fun onClickItem(model: FoodModel)

}