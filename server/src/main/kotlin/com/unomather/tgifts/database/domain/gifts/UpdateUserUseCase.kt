package com.unomather.tgifts.database.domain.gifts

import com.unomather.tgifts.server.domain.gifts.model.User

interface UpdateUserUseCase {
    fun invoke(user: User)
}