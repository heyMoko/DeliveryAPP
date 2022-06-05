package com.project.deliveryapp.screen.main.home.restaurant.detail.review

import com.project.deliveryapp.data.entity.RestaurantReviewEntity
import com.project.deliveryapp.model.restaurant.review.RestaurantReviewModel

sealed class RestaurantReviewState {

    object Uninitialized: RestaurantReviewState()

    object Loading: RestaurantReviewState()

    data class Success(
        val reviewList: List<RestaurantReviewModel>
    ): RestaurantReviewState()

}
