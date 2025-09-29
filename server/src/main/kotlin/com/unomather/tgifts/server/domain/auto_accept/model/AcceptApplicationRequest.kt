package com.unomather.tgifts.server.domain.auto_accept.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AcceptApplicationRequest(
    @SerialName("userId")
    val userId: Long,
    @SerialName("username")
    val username: String,
    @SerialName("name")
    val name: String
)