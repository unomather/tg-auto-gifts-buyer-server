package com.unomather.tgifts.server.domain.gifts.user

import io.ktor.server.routing.Route

interface GetUserRouting {
    fun getUser(route: Route)
}