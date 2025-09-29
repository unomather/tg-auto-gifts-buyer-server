package com.unomather.tgifts.server

import com.unomather.tgifts.database.tables.gifts.UserTable
import com.unomather.tgifts.server.plugins.setupContentNegotiation
import com.unomather.tgifts.server.plugins.setupKoin
import com.unomather.tgifts.server.plugins.setupRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.forwardedheaders.ForwardedHeaders
import io.ktor.server.plugins.forwardedheaders.XForwardedHeaders
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.SchemaUtils
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

fun main() {
    connectDatabase()
    connectServer()
}

/**
 * DATABASE
 */
private fun connectDatabase() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/tg-gifts-db",
        driver = "org.postgresql.Driver",
        user = "unomather",
        password = "Test1234"
    ).also {
        createTables()
    }
}

private fun createTables() = transaction {
    SchemaUtils.create(UserTable)
}

/**
 * SERVER
 */
private fun connectServer() = embeddedServer(
    factory = Netty,
    port = 1337,
    module = {
        setupKoin()
        setupContentNegotiation()
        setupRouting()
        install(ForwardedHeaders)
        install(XForwardedHeaders)
    }
).start(wait = true)