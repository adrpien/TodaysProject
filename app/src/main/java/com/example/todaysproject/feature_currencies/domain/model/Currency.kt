package com.example.todaysproject.feature_currencies.domain.model

data class Currency(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)