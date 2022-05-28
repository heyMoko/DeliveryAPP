package com.project.deliveryapp.data.repository.map

import com.project.deliveryapp.data.entity.LocationLatLngEntity
import com.project.deliveryapp.data.response.address.AddressInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DefaultMapRepository(
    private val ioDispatcher: CoroutineDispatcher
): MapRepository {

    override suspend fun getReverseGeoInformation(
        locationLatLngEntity: LocationLatLngEntity
    ): AddressInfo? = withContext(ioDispatcher) {
        null
    }

}