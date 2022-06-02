package com.project.deliveryapp.di

import com.project.deliveryapp.data.entity.LocationLatLngEntity
import com.project.deliveryapp.data.entity.MapSearchInfoEntity
import com.project.deliveryapp.data.entity.RestaurantEntity
import com.project.deliveryapp.data.repository.map.DefaultMapRepository
import com.project.deliveryapp.data.repository.map.MapRepository
import com.project.deliveryapp.data.repository.restaurant.DefaultRestaurantRepository
import com.project.deliveryapp.data.repository.restaurant.RestaurantRepository
import com.project.deliveryapp.data.repository.user.DefaultUserRepository
import com.project.deliveryapp.data.repository.user.UserRepository
import com.project.deliveryapp.screen.main.home.HomeViewModel
import com.project.deliveryapp.screen.main.home.restaurant.RestaurantCategory
import com.project.deliveryapp.screen.main.home.restaurant.RestaurantListViewModel
import com.project.deliveryapp.screen.main.home.restaurant.detail.RestaurantDetailViewModel
import com.project.deliveryapp.screen.main.my.MyViewModel
import com.project.deliveryapp.screen.mylocation.MyLocationViewModel
import com.project.deliveryapp.util.provider.DefaultResourcesProvider
import com.project.deliveryapp.util.provider.ResourcesProvider
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { HomeViewModel(get(), get()) }
    viewModel { MyViewModel() }
    viewModel { (restaurantCategory: RestaurantCategory, locationLatLng: LocationLatLngEntity) ->
        RestaurantListViewModel(restaurantCategory, locationLatLng, get()) }
    viewModel { (mapSearchInfoEntity: MapSearchInfoEntity) -> MyLocationViewModel(mapSearchInfoEntity, get(), get()) }

    viewModel { (restaurantEntity: RestaurantEntity) -> RestaurantDetailViewModel(restaurantEntity) }

    single<RestaurantRepository> { DefaultRestaurantRepository(get(), get(), get()) }
    single<MapRepository> { DefaultMapRepository(get(), get()) }
    single<UserRepository> { DefaultUserRepository(get(), get()) }

    single { provideGsonConvertFactory() }
    single { buildOkHttpClient() }

    single { provideMapRetrofit(get(), get()) }

    single { provideMapApiService(get()) }

    single { provideDB(androidApplication()) }
    single { provideLocationDao(get()) }

    single<ResourcesProvider> { DefaultResourcesProvider(androidApplication()) }

    single { Dispatchers.IO }
    single { Dispatchers.Main }

}