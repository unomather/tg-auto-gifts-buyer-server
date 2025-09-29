package com.unomather.tgifts.server.data.base

import io.ktor.http.*
import io.ktor.server.plugins.origin
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import javax.crypto.AEADBadTagException
import com.unomather.tgifts.server.domain.routes.Route as AppRoute

abstract class BasePostRoute<Request : Any, Response : Any>(
    private val route: AppRoute,
    private val requestSerializer: KSerializer<Request>,
    private val responseSerializer: KSerializer<Response>
) : BaseRoute<Response>(
    responseSerializer = responseSerializer
) {
    protected abstract suspend fun process(data: Request): Response

    override fun Route.registerRoute() {
        post(route.route) {
            handlePost()
        }
    }

    /**
     * ROUTE
     */
    private suspend fun RoutingContext.handlePost() = runCatching {
        val stringResuest = call.receive<String>()
        runCatching {
            val requestData = json.decodeFromString(string = stringResuest, deserializer = requestSerializer)
            val responseData = process(requestData)
            json.encodeToString(value = responseData, serializer = responseSerializer)
        }.onSuccess { responseString ->
            call.respond(responseString)
        }.onFailure { error ->
            handleError(error)
        }
    }


    /**
     * ERROR HANDLING
     */
    private suspend fun RoutingContext.handleError(error: Throwable) =  when (error) {
        is SerializationException, is IllegalArgumentException -> call.respond(
            status = HttpStatusCode.BadRequest,
            message = ErrorResponse(error = "Bad request", detail = error.localizedMessage)
        )
        is AEADBadTagException -> call.respond(
            status = HttpStatusCode.Unauthorized,
            message = ErrorResponse("Decryption failed")
        )
        else -> call.respond(
            status = HttpStatusCode.InternalServerError,
            message = ErrorResponse("Internal server error")
        )
    }
}

@Serializable
data class ErrorResponse(
    val error: String,
    val detail: String? = null
)