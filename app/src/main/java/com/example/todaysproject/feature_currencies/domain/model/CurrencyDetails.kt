package com.example.todaysproject.feature_currencies.domain.model

import com.example.todaysproject.feature_currencies.data.remote.dto.currency_detail.TeamMember

data class CurrencyDetails(
    val id: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rate: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)