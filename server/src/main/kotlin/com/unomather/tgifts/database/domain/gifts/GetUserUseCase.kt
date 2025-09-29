package com.unomather.tgifts.database.domain.gifts

import com.unomather.tgifts.server.domain.gifts.model.User
import com.unomather.tgifts.server.domain.gifts.model.UserIdRequest

interface GetUserUseCase {
    fun invoke(request: UserIdRequest): User
}