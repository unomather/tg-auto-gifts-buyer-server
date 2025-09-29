package com.unomather.tgifts.database.data

import com.unomather.tgifts.database.domain.GetUserUseCase
import com.unomather.tgifts.database.tables.UserEntity
import com.unomather.tgifts.database.tables.UserTable
import com.unomather.tgifts.server.domain.model.User
import com.unomather.tgifts.server.domain.model.UserIdRequest
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

class GetUserUseCaseImpl: GetUserUseCase {
    override fun invoke(request: UserIdRequest) = transaction {
        UserEntity.find { UserTable.userId eq request.userId }
            .firstOrNull()
            ?.let { userEntity ->
                User(
                    id = userEntity.userId,
                    starBalance = userEntity.starBalance,
                    subscriptionType = userEntity.subscriptionType,
                    subscriptionValidUntil = userEntity.subscriptionValidUntil
                )
            }
            ?: throw IllegalStateException("User not found")
    }
}