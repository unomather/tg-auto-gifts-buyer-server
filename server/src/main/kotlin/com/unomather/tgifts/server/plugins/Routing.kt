package com.unomather.tgifts.server.plugins

import com.unomather.tgifts.server.domain.auto_accept.accept_application.AcceptApplicationRouting
import com.unomather.tgifts.server.domain.gifts.user.GetUserRouting
import com.unomather.tgifts.server.domain.gifts.user.UpdateUserRouting
import io.ktor.server.application.*
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject

internal fun Application.setupRouting() {
    setupAutoAcceptRouting()
}

private fun Application.setupGiftsRouting() {
    val getUserRouting by inject<GetUserRouting>()
    val updateUserRouting by inject<UpdateUserRouting>()
    routing {
        getUserRouting.getUser(this)
        updateUserRouting.updateUser(this)
    }
}

private fun Application.setupAutoAcceptRouting() {
    val acceptApplicationRouting by inject<AcceptApplicationRouting>()
    routing {
        acceptApplicationRouting.acceptRequest(this)
    }
}