package com.example.todaysproject.feature_currencies.domain.use_cases

import com.adrpien.dictionaryapp.core.util.Resource
import com.example.todaysproject.feature_currencies.domain.model.CurrencyDetails
import com.example.todaysproject.feature_currencies.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurrencyById @Inject constructor(private val repository: AppRepository) {

    operator fun invoke(id: String): Flow<Resource<CurrencyDetails>> {
        return repository.getCurrencyById(id)
    }

}