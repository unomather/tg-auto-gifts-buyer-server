package com.unomather.tgifts.server.plugins

import com.unomather.tgifts.server.domain.GetUserRouting
import com.unomather.tgifts.server.domain.UpdateUserRouting
import io.ktor.server.application.*
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject

internal fun Application.setupRouting() {
    val getUserRouting by inject<GetUserRouting>()
    val updateUserRouting by inject<UpdateUserRouting>()
    routing {
        getUserRouting.getUser(this)
        updateUserRouting.updateUser(this)
    }
}