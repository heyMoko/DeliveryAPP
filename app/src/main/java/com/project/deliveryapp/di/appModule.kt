package com.project.deliveryapp.di

import com.project.deliveryapp.data.entity.LocationLatLngEntity
import com.project.deliveryapp.data.entity.MapSearchInfoEntity
import com.project.deliveryapp.data.entity.RestaurantEntity
import com.project.deliveryapp.data.entity.RestaurantFoodEntity
import com.project.deliveryapp.data.repository.map.DefaultMapRepository
import com.project.deliveryapp.data.repository.map.MapRepository
import com.project.deliveryapp.data.repository.restaurant.DefaultRestaurantRepository
import com.project.deliveryapp.data.repository.restaurant.RestaurantRepository
import com.project.deliveryapp.data.repository.restaurant.food.DefaultRestaurantFoodRepository
import com.project.deliveryapp.data.repository.restaurant.food.RestaurantFoodRepository
import com.project.deliveryapp.data.repository.restaurant.review.DefaultRestaurantReviewRepository
import com.project.deliveryapp.data.repository.restaurant.review.RestaurantReviewRepository
import com.project.deliveryapp.data.repository.user.DefaultUserRepository
import com.project.deliveryapp.data.repository.user.UserRepository
import com.project.deliveryapp.screen.main.home.HomeViewModel
import com.project.deliveryapp.screen.main.home.restaurant.RestaurantCategory
import com.project.deliveryapp.screen.main.home.restaurant.RestaurantListViewModel
import com.project.deliveryapp.screen.main.home.restaurant.detail.RestaurantDetailViewModel
import com.project.deliveryapp.screen.main.home.restaurant.detail.menu.RestaurantMenuListViewModel
import com.project.deliveryapp.screen.main.home.restaurant.detail.review.RestaurantReviewListViewModel
import com.project.deliveryapp.screen.main.my.MyViewModel
import com.project.deliveryapp.screen.mylocation.MyLocationViewModel
import com.project.deliveryapp.util.provider.DefaultResourcesProvider
import com.project.deliveryapp.util.provider.ResourcesProvider
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    viewModel { HomeViewModel(get(), get(), get()) }
    viewModel { MyViewModel() }
    viewModel { (restaurantCategory: RestaurantCategory, locationLatLng: LocationLatLngEntity) ->
        RestaurantListViewModel(restaurantCategory, locationLatLng, get()) }
    viewModel { (mapSearchInfoEntity: MapSearchInfoEntity) -> MyLocationViewModel(mapSearchInfoEntity, get(), get()) }

    viewModel { (restaurantEntity: RestaurantEntity) -> RestaurantDetailViewModel(restaurantEntity, get(), get()) }

    viewModel { (restaurantId: Long, restaurantFoodList: List<RestaurantFoodEntity>) ->
        RestaurantMenuListViewModel(restaurantId, restaurantFoodList, get())
    }
    viewModel { (restaurantTitle: String) -> RestaurantReviewListViewModel(restaurantTitle, get()) }

    single<RestaurantRepository> { DefaultRestaurantRepository(get(), get(), get()) }
    single<MapRepository> { DefaultMapRepository(get(), get()) }
    single<UserRepository> { DefaultUserRepository(get(), get(), get()) }
    single<RestaurantFoodRepository> { DefaultRestaurantFoodRepository(get(), get(), get()) }
    single<RestaurantReviewRepository> {  DefaultRestaurantReviewRepository(get()) }

    single { provideGsonConvertFactory() }
    single { buildOkHttpClient() }

    single(named("map")) { provideMapRetrofit(get(), get()) }
    single(named("food")) { provideFoodRetrofit(get(), get()) }

    single { provideMapApiService(get(qualifier = named("map"))) }
    single { provideFoodApiService(get(qualifier = named("food"))) }

    single { provideDB(androidApplication()) }
    single { provideLocationDao(get()) }
    single { provideRestaurantDao(get()) }
    single { provideFoodMenuBasketDao(get()) }

    single<ResourcesProvider> { DefaultResourcesProvider(androidApplication()) }

    single { Dispatchers.IO }
    single { Dispatchers.Main }

}