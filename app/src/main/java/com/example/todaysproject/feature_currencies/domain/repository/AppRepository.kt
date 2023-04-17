package com.example.todaysproject.feature_currencies.domain.repository

import com.adrpien.dictionaryapp.core.util.Resource
import com.example.todaysproject.feature_currencies.domain.model.CurrencyDetails
import com.example.todaysproject.feature_currencies.domain.model.Currency
import kotlinx.coroutines.flow.Flow

interface AppRepository {

    fun getCurrencyList(): Flow<Resource<List<Currency>>>

    fun getCurrencyById(id: String): Flow<Resource<CurrencyDetails>>

}