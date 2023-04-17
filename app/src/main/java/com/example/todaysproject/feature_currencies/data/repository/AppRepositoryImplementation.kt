package com.example.todaysproject.feature_currencies.data.repository

import com.adrpien.dictionaryapp.core.util.Resource
import com.adrpien.dictionaryapp.core.util.ResourceState
import com.example.todaysproject.feature_currencies.data.local.RoomDao
import com.example.todaysproject.feature_currencies.data.remote.api.CoinPaprikaApi
import com.example.todaysproject.feature_currencies.domain.model.CurrencyDetails
import com.example.todaysproject.feature_currencies.domain.model.Currency
import com.example.todaysproject.feature_currencies.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AppRepositoryImplementation @Inject constructor(
    private val roomDao: RoomDao,
    private val coinPaprikaApi: CoinPaprikaApi
): AppRepository {

    override fun getCurrencyList(): Flow<Resource<List<Currency>>> = flow {
        emit(Resource(ResourceState.LOADING, null, "api_request_starts"))
        try {
            val currencyList = coinPaprikaApi.getCurrencyList().map {
                it.toCurrency()
            }
            emit(Resource(ResourceState.SUCCESS, currencyList, "api_data"))

        } catch (e: HttpException) {
            emit(Resource(ResourceState.ERROR, null, "http_exception"))
        } catch (e: IOException) {
            emit(Resource(ResourceState.ERROR, null, "io_exception"))
        }

    }

    override fun getCurrencyById(id: String) = flow {
        emit(Resource(ResourceState.LOADING, null, "api_request_starts"))
        try {
            val currency = coinPaprikaApi.getCurrencyById(id).toCurrencyDetails()
            emit(Resource(ResourceState.SUCCESS, currency, "api_data"))
        } catch (e: HttpException) {
            emit(Resource(ResourceState.ERROR, null, "http_exception"))
        } catch (e: IOException) {
            emit(Resource(ResourceState.ERROR, null, "io_exception"))
        }
    }

}