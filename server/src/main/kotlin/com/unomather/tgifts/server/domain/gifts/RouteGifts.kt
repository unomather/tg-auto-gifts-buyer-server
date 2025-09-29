package com.unomather.tgifts.server.domain.gifts

import com.unomather.tgifts.server.domain.BaseRoute

sealed class RouteGifts(override val route: String): BaseRoute {
    data object GetUserRoute: RouteGifts(route = "getUser")
    data object UpdateUserRoute: RouteGifts(route = "updateUser")
}