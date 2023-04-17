package com.example.todaysproject.feature_currencies.domain.use_cases

import com.adrpien.dictionaryapp.core.util.Resource
import com.example.todaysproject.feature_currencies.domain.model.Currency
import com.example.todaysproject.feature_currencies.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurrencyList @Inject constructor(
    val repository: AppRepository
) {

   operator fun invoke(): Flow<Resource<List<Currency>>>{
        return repository.getCurrencyList()
    }

}