package com.project.deliveryapp.data.repository.map

import com.project.deliveryapp.data.entity.LocationLatLngEntity
import com.project.deliveryapp.data.response.address.AddressInfo

interface MapRepository {

    suspend fun getReverseGeoInformation(
        locationLatLngEntity: LocationLatLngEntity
    ): AddressInfo?

}