package com.unomather.tgifts.firebase.data

import com.google.firebase.database.FirebaseDatabase
import com.unomather.tgifts.firebase.domain.AddApplicationUseCase

internal class AddApplicationUseCaseImpl(
    private val database: FirebaseDatabase
): AddApplicationUseCase {
    override fun invoke(data: AddApplicationUseCase.Data) {
        val userId = data.request.userId.toString()
        val map = mapOf("ip" to data.ip, "name" to data.request.name, "userId" to userId)
        database.getReference(data.request.username).setValueAsync(map)
    }
}