package com.unomather.tgifts.server.data.gifts

import com.unomather.tgifts.database.domain.gifts.GetUserUseCase
import com.unomather.tgifts.server.data.base.BasePostRoute
import com.unomather.tgifts.server.domain.gifts.user.GetUserRouting
import com.unomather.tgifts.server.domain.gifts.model.User
import com.unomather.tgifts.server.domain.gifts.model.UserIdRequest
import com.unomather.tgifts.server.domain.gifts.RouteGifts.GetUserRoute
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