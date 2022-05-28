package com.project.deliveryapp.screen.main.home

sealed class HomeState {

    object UnInitialized: HomeState()

    object Loading: HomeState()

    object Success: HomeState()

}
