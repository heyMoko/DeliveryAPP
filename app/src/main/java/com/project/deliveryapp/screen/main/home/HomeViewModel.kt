package com.project.deliveryapp.screen.main.home

import androidx.lifecycle.MutableLiveData
import com.project.deliveryapp.screen.base.BaseViewModel

class HomeViewModel: BaseViewModel() {

    val homeStateLiveData = MutableLiveData<HomeState>(HomeState.UnInitialized)

}