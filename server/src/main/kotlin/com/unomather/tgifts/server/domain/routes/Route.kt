package com.unomather.tgifts.server.domain.routes

sealed class Route(val route: String) {
    data object GetUserRoute: Route(route = "getUser")
    data object UpdateUserRoute: Route(route = "updateUser")
}