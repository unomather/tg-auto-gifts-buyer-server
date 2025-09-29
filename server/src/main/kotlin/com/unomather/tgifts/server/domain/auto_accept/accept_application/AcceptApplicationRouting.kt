package com.unomather.tgifts.server.domain.auto_accept.accept_application

import io.ktor.server.routing.Route

interface AcceptApplicationRouting {
    fun acceptRequest(route: Route)
}