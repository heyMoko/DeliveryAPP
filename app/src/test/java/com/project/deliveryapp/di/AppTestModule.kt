package com.project.deliveryapp.di

import com.google.firebase.auth.FirebaseAuth
import com.project.deliveryapp.data.TestOrderRepository
import com.project.deliveryapp.data.TestRestaurantFoodRepository
import com.project.deliveryapp.data.TestRestaurantRepository
import com.project.deliveryapp.data.entity.LocationLatLngEntity
import com.project.deliveryapp.data.repository.order.OrderRepository
import com.project.deliveryapp.data.repository.restaurant.RestaurantRepository
import com.project.deliveryapp.data.repository.restaurant.food.RestaurantFoodRepository
import com.project.deliveryapp.screen.main.home.restaurant.RestaurantCategory
import com.project.deliveryapp.screen.main.home.restaurant.RestaurantListViewModel
import com.project.deliveryapp.screen.order.OrderMenuListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
internal val appTestModule = module {

    viewModel { (restaurantCategory: RestaurantCategory, locationLatLng: LocationLatLngEntity) ->
        RestaurantListViewModel(restaurantCategory, locationLatLng, get()
        )
    }

    viewModel { (firebaseAuth: FirebaseAuth) -> OrderMenuListViewModel(get(), get(), firebaseAuth) }

    single<RestaurantRepository> { TestRestaurantRepository() }

    single<RestaurantFoodRepository> { TestRestaurantFoodRepository() }

    single<OrderRepository> { TestOrderRepository() }
}