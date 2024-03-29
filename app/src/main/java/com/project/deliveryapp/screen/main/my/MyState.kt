package com.project.deliveryapp.screen.main.my

import android.net.Uri
import androidx.annotation.StringRes
import com.project.deliveryapp.data.entity.OrderEntity
import com.project.deliveryapp.model.restaurant.order.OrderModel
import com.project.deliveryapp.screen.main.home.restaurant.detail.review.RestaurantReviewState

sealed class MyState {

    object Uninitialized: MyState()

    object Loading: MyState()

    data class Login(
        val idToken : String
    ): MyState()

    sealed class Success: MyState() {

        data class Registered(
            val userName: String,
            val profileImageUri: Uri?,
            val orderList: List<OrderModel>
        ): Success()

        object NotRegistered: Success()

    }

    data class Error(
        @StringRes val messageId: Int,
        val e: Throwable
    ): MyState()

}