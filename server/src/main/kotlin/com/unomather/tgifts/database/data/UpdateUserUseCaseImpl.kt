package com.unomather.tgifts.database.data

import com.unomather.tgifts.database.domain.UpdateUserUseCase
import com.unomather.tgifts.database.tables.UserEntity
import com.unomather.tgifts.database.tables.UserTable
import com.unomather.tgifts.server.domain.model.User
import org.jetbrains.exposed.v1.core.SqlExpressionBuilder.eq
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

class UpdateUserUseCaseImpl: UpdateUserUseCase {
    override fun invoke(user: User) {
        transaction {
            val existingUser = UserEntity.find { UserTable.userId eq user.id }.firstOrNull()
            if (existingUser == null) {
                UserEntity.new {
                    this.userId = user.id
                    this.starBalance = user.starBalance
                    this.subscriptionType = user.subscriptionType
                    this.subscriptionValidUntil = user.subscriptionValidUntil
                }
            } else {
                UserEntity.findSingleByAndUpdate(UserTable.userId eq user.id) { entity ->
                    entity.userId = user.id
                    entity.starBalance = user.starBalance
                    entity.subscriptionType = user.subscriptionType
                    entity.subscriptionValidUntil = user.subscriptionValidUntil
                }
            }
        }
    }
}