package com.unomather.tgifts.server.plugins

import com.unomather.tgifts.database.di.moduleDatabase
import com.unomather.tgifts.server.di.moduleRouting
import io.ktor.server.application.Application
import io.ktor.server.application.install
import org.koin.core.logger.Level
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

internal fun Application.setupKoin() {
    install(Koin) {
        slf4jLogger(level = Level.ERROR)
        modules(allModules)
    }
}

private val allModules = listOf(
    moduleRouting,
    moduleDatabase
)