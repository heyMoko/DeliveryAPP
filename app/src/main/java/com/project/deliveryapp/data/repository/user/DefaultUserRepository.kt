package com.project.deliveryapp.data.repository.user

import com.project.deliveryapp.data.db.dao.LocationDao
import com.project.deliveryapp.data.entity.LocationLatLngEntity
import kotlinx.coroutines.CoroutineDispatcher

class DefaultUserRepository(
    private val locationDao: LocationDao,
    private val ioDispatcher: CoroutineDispatcher
): UserRepository {

    override suspend fun getUserLocation(): LocationLatLngEntity? {

    }

    override suspend fun insertUserLocation(locationLatLngEntity: LocationLatLngEntity) {
    }

}