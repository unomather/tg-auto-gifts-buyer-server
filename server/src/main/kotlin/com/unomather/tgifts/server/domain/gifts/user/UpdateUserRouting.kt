package com.unomather.tgifts.server.domain.gifts.user

import io.ktor.server.routing.Route

interface UpdateUserRouting {
    fun updateUser(route: Route)
}