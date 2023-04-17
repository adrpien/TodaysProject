package com.example.todaysproject.feature_currencies.data.remote.dto.currency_list

import com.example.todaysproject.feature_currencies.domain.model.Currency

data class CurrencyDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
){
    fun toCurrency(): Currency {
        return Currency(
            id = id,
            name = name,
            rank  = rank,
            symbol = symbol,
            isActive = is_active
        )
    }
}