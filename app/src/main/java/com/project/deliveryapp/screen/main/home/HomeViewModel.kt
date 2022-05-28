package com.project.deliveryapp.screen.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.project.deliveryapp.data.entity.LocationLatLngEntity
import com.project.deliveryapp.screen.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel: BaseViewModel() {

    val homeStateLiveData = MutableLiveData<HomeState>(HomeState.UnInitialized)

    fun loadReverseGeoInformation(
        locationLatLngEntity: LocationLatLngEntity
    ) = viewModelScope.launch {

    }

}