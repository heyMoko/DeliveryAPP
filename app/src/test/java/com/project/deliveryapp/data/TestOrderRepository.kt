package com.project.deliveryapp.data

import com.project.deliveryapp.data.entity.OrderEntity
import com.project.deliveryapp.data.entity.RestaurantFoodEntity
import com.project.deliveryapp.data.repository.order.DefaultOrderRepository
import com.project.deliveryapp.data.repository.order.OrderRepository

class TestOrderRepository: OrderRepository {

    private var orderEntities = mutableListOf<OrderEntity>()

    override suspend fun orderMenu(
        userId: String,
        restaurantId: Long,
        foodMenuList: List<RestaurantFoodEntity>,
        restaurantTitle: String
    ): DefaultOrderRepository.Result {

        orderEntities.add(
            OrderEntity(
                id = orderEntities.size.toString(),
                userId = userId,
                restaurantId = restaurantId,
                foodMenuList = foodMenuList.map { it.copy() },
                restaurantTitle = restaurantTitle
            )
        )
        return DefaultOrderRepository.Result.Success<Any>()

    }

    override suspend fun getAllOrderMenus(userId: String): DefaultOrderRepository.Result {

        return DefaultOrderRepository.Result.Success<Any>(orderEntities)

    }
}