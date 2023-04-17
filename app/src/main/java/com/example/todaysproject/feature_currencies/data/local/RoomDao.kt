package com.example.todaysproject.feature_currencies.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.todaysproject.feature_currencies.domain.model.Currency
import com.example.todaysproject.feature_currencies.domain.model.CurrencyDetails

@Dao
interface RoomDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrency(currency: CurrencyDetails)

    @Query("SELECT * FROM currency")
    suspend fun getCurrencyList(): List<Currency>

    @Query("SELECT * FROM currencydetails WHERE id LIKE :word")
    suspend fun getCurrencyDetails(id: String): CurrencyDetails

}