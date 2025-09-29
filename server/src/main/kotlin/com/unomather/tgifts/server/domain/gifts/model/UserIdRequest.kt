package com.unomather.tgifts.server.domain.gifts.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserIdRequest(
    @SerialName("user_id")
    val userId: Int
)