package com.project.deliveryapp.screen.main.home.restaurant.detail

import androidx.annotation.StringRes
import com.project.deliveryapp.R

enum class RestaurantCategoryDetail(
    @StringRes val categoryNameId: Int
) {

    MENU(R.string.menu), REVIEW(R.string.review)

}