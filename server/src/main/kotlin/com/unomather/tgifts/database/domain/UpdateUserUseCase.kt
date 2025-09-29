package com.unomather.tgifts.database.domain

import com.unomather.tgifts.server.domain.model.User

interface UpdateUserUseCase {
    fun invoke(user: User)
}