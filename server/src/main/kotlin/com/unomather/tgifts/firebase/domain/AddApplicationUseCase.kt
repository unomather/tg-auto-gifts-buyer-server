package com.unomather.tgifts.firebase.domain

import com.unomather.tgifts.server.domain.auto_accept.model.AcceptApplicationRequest

interface AddApplicationUseCase {
    operator fun invoke(data: Data)
    data class Data(
        val ip: String,
        val request: AcceptApplicationRequest
    )
}