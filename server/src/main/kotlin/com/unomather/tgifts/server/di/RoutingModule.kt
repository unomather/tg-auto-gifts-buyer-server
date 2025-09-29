package com.unomather.tgifts.server.di

import com.unomather.tgifts.server.data.auto_accept.AcceptApplicationRoutingImpl
import com.unomather.tgifts.server.data.gifts.GetUserRoutingImpl
import com.unomather.tgifts.server.data.gifts.UpdateUserRoutingImpl
import com.unomather.tgifts.server.domain.auto_accept.accept_application.AcceptApplicationRouting
import com.unomather.tgifts.server.domain.gifts.user.GetUserRouting
import com.unomather.tgifts.server.domain.gifts.user.UpdateUserRouting
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val moduleRouting = module {
    /**
     * BASE
     */
    factory {
        Json {
            isLenient = true
            prettyPrint = true
            ignoreUnknownKeys = true
        }
    }
    /**
     * GIFTS
     */
    factoryOf(::GetUserRoutingImpl) { bind<GetUserRouting>() }
    factoryOf(::UpdateUserRoutingImpl) { bind<UpdateUserRouting>() }
    /**
     * AUTO ACCEPT
     */
    factoryOf(::AcceptApplicationRoutingImpl) { bind<AcceptApplicationRouting>() }
}