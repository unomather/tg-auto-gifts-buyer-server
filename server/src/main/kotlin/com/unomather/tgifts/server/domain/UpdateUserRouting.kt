package com.unomather.tgifts.server.domain

import io.ktor.server.routing.Route

interface UpdateUserRouting {
    fun updateUser(route: Route)
}