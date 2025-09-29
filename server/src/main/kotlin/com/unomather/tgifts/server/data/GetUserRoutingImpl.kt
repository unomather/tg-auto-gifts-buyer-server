package com.unomather.tgifts.server.data

import com.unomather.tgifts.database.domain.GetUserUseCase
import com.unomather.tgifts.server.data.base.BasePostRoute
import com.unomather.tgifts.server.domain.GetUserRouting
import com.unomather.tgifts.server.domain.model.User
import com.unomather.tgifts.server.domain.model.UserIdRequest
import com.unomather.tgifts.server.domain.routes.Route.GetUserRoute
import io.ktor.server.routing.*

class GetUserRoutingImpl(
    private val getUserUseCase: GetUserUseCase
): GetUserRouting, BasePostRoute<UserIdRequest, User>(
    route = GetUserRoute,
    requestSerializer = UserIdRequest.serializer(),
    responseSerializer = User.serializer()
) {
    override fun getUser(route: Route) {
        route.registerRoute()
    }

    override suspend fun process(data: UserIdRequest) = getUserUseCase.invoke(data)
}