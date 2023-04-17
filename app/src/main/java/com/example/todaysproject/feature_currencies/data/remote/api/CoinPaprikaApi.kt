package com.example.todaysproject.feature_currencies.data.remote.api

import com.example.todaysproject.feature_currencies.data.remote.dto.currency_detail.CurrencyDetailsDto
import com.example.todaysproject.feature_currencies.data.remote.dto.currency_list.CurrencyDto
import retrofit2.http.GET
import retrofit2.http.Path


interface CoinPaprikaApi {

    @GET("/v1/coins/{id}")
    fun getCurrencyById(@Path("id") id: String): CurrencyDetailsDto

    @GET("/v1/coins")
    fun getCurrencyList(): List<CurrencyDto>

    companion object {
        const val BASE_URL = "https://api.coinpaprika.com/"
    }
}