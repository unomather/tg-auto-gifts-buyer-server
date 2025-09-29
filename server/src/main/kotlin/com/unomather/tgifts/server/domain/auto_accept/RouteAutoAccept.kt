package com.unomather.tgifts.server.domain.auto_accept

import com.unomather.tgifts.server.domain.BaseRoute

sealed class RouteAutoAccept(override val route: String): BaseRoute {
    data object AcceptApplicationRoute: RouteAutoAccept(route = "accept")
}