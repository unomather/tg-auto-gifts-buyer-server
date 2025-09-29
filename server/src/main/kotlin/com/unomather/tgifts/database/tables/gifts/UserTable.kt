package com.unomather.tgifts.database.tables.gifts

import org.jetbrains.exposed.v1.core.dao.id.EntityID
import org.jetbrains.exposed.v1.core.dao.id.UUIDTable
import org.jetbrains.exposed.v1.dao.UUIDEntity
import org.jetbrains.exposed.v1.dao.UUIDEntityClass
import java.util.UUID

object UserTable: UUIDTable("user") {
    val userId = integer("user_id") // telegram id
    val starBalance = integer("star_balance") // starts on balance
    val subscriptionType = integer("subscription_type") // 1 = tracking, 2 = purchase
    val subscriptionValidUntil = long("subscription_valid_until") // Clock.now()
}

class UserEntity(id: EntityID<UUID>): UUIDEntity(id) {
    var userId by UserTable.userId
    var starBalance by UserTable.starBalance
    var subscriptionType by UserTable.subscriptionType
    var subscriptionValidUntil by UserTable.subscriptionValidUntil

    companion object : UUIDEntityClass<UserEntity>(UserTable)
}