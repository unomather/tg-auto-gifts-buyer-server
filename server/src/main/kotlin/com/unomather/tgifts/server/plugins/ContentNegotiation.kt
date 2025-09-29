package com.unomather.tgifts.server.plugins

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import kotlinx.serialization.json.Json
import org.koin.ktor.ext.inject

fun Application.setupContentNegotiation() {
    val json by inject<Json>()
    install(ContentNegotiation) {
        json(json)
    }
}