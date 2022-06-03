package com.project.deliveryapp.model.restaurant.food

import com.project.deliveryapp.model.CellType
import com.project.deliveryapp.model.Model


data class FoodModel(
    override val id: Long,
    override val type: CellType = CellType.FOOD_CELL,
    val title: String,
    val description: String,
    val price: Int,
    val imageUrl: String,
    val restaurantId: Long
): Model(id, type)