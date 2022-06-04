package com.project.deliveryapp.model.restaurant.food

import com.project.deliveryapp.data.entity.RestaurantFoodEntity
import com.project.deliveryapp.model.CellType
import com.project.deliveryapp.model.Model


data class FoodModel(
    override val id: Long,
    override val type: CellType = CellType.FOOD_CELL,
    val title: String,
    val description: String,
    val price: Int,
    val imageUrl: String,
    val restaurantId: Long,
    val foodId: String
): Model(id, type) {

    fun toEntity(basketIndex: Int) = RestaurantFoodEntity(
        "${foodId}_${basketIndex}", title, description, price, imageUrl, restaurantId
    )

}