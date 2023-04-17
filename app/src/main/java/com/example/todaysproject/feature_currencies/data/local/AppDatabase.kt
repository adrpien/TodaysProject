package com.example.todaysproject.feature_currencies.data.local

import androidx.room.Database
import com.example.todaysproject.feature_currencies.domain.model.Currency
import com.example.todaysproject.feature_currencies.domain.model.CurrencyDetails

@Database(
    entities = [Currency::class, CurrencyDetails::class],
    version = 1
)

abstract class AppDatabase: androidx.room.RoomDatabase() {

    abstract val dao: RoomDao

}