package com.unomather.tgifts.server.domain

import io.ktor.server.routing.Route

interface GetUserRouting {
    fun getUser(route: Route)
}