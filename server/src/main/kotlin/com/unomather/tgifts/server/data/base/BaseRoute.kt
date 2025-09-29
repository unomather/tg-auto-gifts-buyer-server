package com.unomather.tgifts.server.data.base

import io.ktor.server.routing.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseRoute<Response : Any>(
    private val responseSerializer: KSerializer<Response>
): KoinComponent {
    /**
     * DATA
     */
    protected val json by inject<Json>()

    /**
     * REGISTRATION
     */
    abstract fun Route.registerRoute()
}