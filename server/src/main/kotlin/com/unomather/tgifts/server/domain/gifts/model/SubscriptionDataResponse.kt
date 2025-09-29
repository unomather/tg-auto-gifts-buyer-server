package com.unomather.tgifts.server.domain.gifts.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SubscriptionDataResponse(
    @SerialName("subscriptionType")
    val subscriptionType: Int,
    @SerialName("subscriptionValidUntil")
    val subscriptionValidUntil: Long
)