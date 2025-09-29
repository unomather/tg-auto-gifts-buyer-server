package com.unomather.tgifts.server.data.auto_accept

import com.unomather.tgifts.firebase.domain.AddApplicationUseCase
import com.unomather.tgifts.server.data.base.BasePostRoute
import com.unomather.tgifts.server.data.gifts.Success
import com.unomather.tgifts.server.domain.auto_accept.RouteAutoAccept.AcceptApplicationRoute
import com.unomather.tgifts.server.domain.auto_accept.accept_application.AcceptApplicationRouting
import com.unomather.tgifts.server.domain.auto_accept.model.AcceptApplicationRequest
import io.ktor.server.routing.*

class AcceptApplicationRoutingImpl(
    private val addApplicationUseCase: AddApplicationUseCase
): AcceptApplicationRouting, BasePostRoute<AcceptApplicationRequest, Success>(
    route = AcceptApplicationRoute,
    requestSerializer = AcceptApplicationRequest.serializer(),
    responseSerializer = Success.serializer()
) {
    override fun acceptRequest(route: Route) {
        route.registerRoute()
    }

    override suspend fun process(call: RoutingCall, data: AcceptApplicationRequest): Success {
        val requestData = AddApplicationUseCase.Data(
            request = data,
            ip = call.request.local.remoteAddress
        )
        return runCatching {
            addApplicationUseCase(requestData)
        }.mapCatching {
            Success(isSuccess = true)
        }.getOrElse {
            Success(isSuccess = false)
        }
    }
}