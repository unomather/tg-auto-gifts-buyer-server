package com.unomather.tgifts.server.data

import com.unomather.tgifts.database.domain.UpdateUserUseCase
import com.unomather.tgifts.server.data.base.BasePostRoute
import com.unomather.tgifts.server.domain.UpdateUserRouting
import com.unomather.tgifts.server.domain.model.User
import com.unomather.tgifts.server.domain.routes.Route.UpdateUserRoute
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

    override suspend fun process(data: User): Success {
        updateUserUseCase.invoke(data)
        return Success()
    }
}

@Serializable
data class Success(val isSuccess: Boolean = true)