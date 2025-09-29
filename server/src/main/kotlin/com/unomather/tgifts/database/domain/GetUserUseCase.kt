package com.unomather.tgifts.database.domain

import com.unomather.tgifts.server.domain.model.User
import com.unomather.tgifts.server.domain.model.UserIdRequest

interface GetUserUseCase {
    fun invoke(request: UserIdRequest): User
}