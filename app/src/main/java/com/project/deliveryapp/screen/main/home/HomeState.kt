package com.project.deliveryapp.screen.main.home

import androidx.annotation.StringRes
import com.project.deliveryapp.data.entity.MapSearchInfoEntity

sealed class HomeState {

    object UnInitialized: HomeState()

    object Loading: HomeState()

    data class Success(
        val mapSearchInfo: MapSearchInfoEntity
    ): HomeState()

    data class Error(
        @StringRes val messageId: Int
    ): HomeState()

}
