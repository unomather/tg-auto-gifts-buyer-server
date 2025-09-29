package com.unomather.tgifts.server.data.gifts

import com.unomather.tgifts.database.domain.gifts.UpdateUserUseCase
import com.unomather.tgifts.server.data.base.BasePostRoute
import com.unomather.tgifts.server.domain.gifts.user.UpdateUserRouting
import com.unomather.tgifts.server.domain.gifts.model.User
import com.unomather.tgifts.server.domain.gifts.RouteGifts.UpdateUserRoute
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

class UpdateUserRoutingImpl(
    private val updateUserUseCase: UpdateUserUseCase
): UpdateUserRouting, BasePostRoute<User, Success>(
    route = UpdateUserRoute,
    requestSerializer = User.serializer(),
    responseSerializer = Success.serializer()
) {
    override fun updateUser(route: Route) {
        route.registerRoute()
    }

    override suspend fun process(call: RoutingCall, data: User): Success {
        updateUserUseCase.invoke(data)
        return Success()
    }
}

@Serializable
data class Success(val isSuccess: Boolean = true)