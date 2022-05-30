package com.project.deliveryapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.deliveryapp.data.db.dao.LocationDao
import com.project.deliveryapp.data.entity.LocationLatLngEntity

@Database(
    entities = [LocationLatLngEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ApplicationDatabase: RoomDatabase() {

    companion object {
        const val DB_NAME = "ApplicationDatabase.db"
    }

    abstract fun LocationDao(): LocationDao

}