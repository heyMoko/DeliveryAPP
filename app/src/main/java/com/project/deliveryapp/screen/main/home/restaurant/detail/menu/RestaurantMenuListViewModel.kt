package com.project.deliveryapp.screen.main.home.restaurant.detail.menu

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.project.deliveryapp.data.entity.RestaurantFoodEntity
import com.project.deliveryapp.data.repository.restaurant.food.RestaurantFoodRepository
import com.project.deliveryapp.model.restaurant.food.FoodModel
import com.project.deliveryapp.screen.base.BaseFragment
import com.project.deliveryapp.screen.base.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RestaurantMenuListViewModel(
    private val restaurantId: Long,
    private val foodEntityList: List<RestaurantFoodEntity>,
    private val restaurantFoodRepository: RestaurantFoodRepository
): BaseViewModel() {

    val restaurantFoodListLiveData = MutableLiveData<List<FoodModel>>()

    override fun fetchData(): Job = viewModelScope.launch {
        restaurantFoodListLiveData.value = foodEntityList.map {
            FoodModel(
                id = it.hashCode().toLong(),
                title = it.title,
                description = it.description,
                price = it.price,
                imageUrl = it.imageUrl,
                restaurantId = restaurantId
            )
        }
    }

    fun insertMenuInBasket(model: FoodModel) = viewModelScope.launch {
        val restaurantMenuListInBasket = restaurantFoodRepository.
    }
}