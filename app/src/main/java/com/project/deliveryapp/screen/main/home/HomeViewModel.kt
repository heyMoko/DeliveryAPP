package com.project.deliveryapp.screen.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.project.deliveryapp.R
import com.project.deliveryapp.data.entity.LocationLatLngEntity
import com.project.deliveryapp.data.entity.MapSearchInfoEntity
import com.project.deliveryapp.data.repository.map.MapRepository
import com.project.deliveryapp.screen.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel(
    private val mapRepository: MapRepository
): BaseViewModel() {

    companion object {
        const val MY_LOCATION_KEY = "MyLocation"
    }

    val homeStateLiveData = MutableLiveData<HomeState>(HomeState.UnInitialized)

    fun loadReverseGeoInformation(
        locationLatLngEntity: LocationLatLngEntity
    ) = viewModelScope.launch {
        homeStateLiveData.value = HomeState.Loading
        val addressInfo = mapRepository.getReverseGeoInformation(locationLatLngEntity)
        addressInfo?.let { info ->
            homeStateLiveData.value = HomeState.Success(
                mapSearchInfo = info.toSearchInfoEntity(locationLatLngEntity)
            )
        } ?: kotlin.run {
            homeStateLiveData.value = HomeState.Error(
                messageId = R.string.can_not_load_address_info
            )
        }
    }
    fun getMapSearchInfo(): MapSearchInfoEntity? {
        when (val data = homeStateLiveData.value) {
            is HomeState.Success -> {
                return data.mapSearchInfo
            }
        }
        return null
    }
}