package com.project.deliveryapp.data.repository.restaurant.review

import com.project.deliveryapp.data.entity.RestaurantReviewEntity

interface RestaurantReviewRepository {

    suspend fun getReviews(restaurantTitle: String): List<RestaurantReviewEntity>

}