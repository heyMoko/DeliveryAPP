package com.project.deliveryapp.data.repository.map

import com.project.deliveryapp.data.entity.LocationLatLngEntity
import com.project.deliveryapp.data.network.MapApiService
import com.project.deliveryapp.data.response.address.AddressInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DefaultMapRepository(
    private val mapApiService: MapApiService,
    private val ioDispatcher: CoroutineDispatcher
): MapRepository {

    override suspend fun getReverseGeoInformation(
        locationLatLngEntity: LocationLatLngEntity
    ): AddressInfo? = withContext(ioDispatcher) {
        val response = mapApiService.getReverseGeoCode(
            lat = locationLatLngEntity.latitude,
            lon = locationLatLngEntity.longitude
        )
        if(response.isSuccessful) {
            response.body()?.addressInfo
        } else {
            null
        }
    }

}