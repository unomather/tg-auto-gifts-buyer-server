package com.unomather.tgifts.database.data.gifts

import com.unomather.tgifts.database.domain.gifts.GetUserUseCase
import com.unomather.tgifts.database.tables.gifts.UserEntity
import com.unomather.tgifts.database.tables.gifts.UserTable
import com.unomather.tgifts.server.domain.gifts.model.User
import com.unomather.tgifts.server.domain.gifts.model.UserIdRequest
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