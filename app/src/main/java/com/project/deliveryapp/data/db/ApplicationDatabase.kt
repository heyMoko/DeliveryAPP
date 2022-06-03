package com.project.deliveryapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.deliveryapp.data.db.dao.FoodMenuBasketDao
import com.project.deliveryapp.data.db.dao.LocationDao
import com.project.deliveryapp.data.db.dao.RestaurantDao
import com.project.deliveryapp.data.entity.LocationLatLngEntity
import com.project.deliveryapp.data.entity.RestaurantEntity
import com.project.deliveryapp.data.entity.RestaurantFoodEntity

@Database(
    entities = [LocationLatLngEntity::class, RestaurantEntity::class, RestaurantFoodEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ApplicationDatabase: RoomDatabase() {

    companion object {
        const val DB_NAME = "ApplicationDatabase.db"
    }

    abstract fun LocationDao(): LocationDao

    abstract fun RestaurantDao(): RestaurantDao

    abstract fun FoodMenuBasketDao(): FoodMenuBasketDao

}