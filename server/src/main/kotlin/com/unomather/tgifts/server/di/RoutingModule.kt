package com.unomather.tgifts.server.di

import com.unomather.tgifts.server.data.GetUserRoutingImpl
import com.unomather.tgifts.server.data.UpdateUserRoutingImpl
import com.unomather.tgifts.server.domain.GetUserRouting
import com.unomather.tgifts.server.domain.UpdateUserRouting
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val moduleRouting = module {
    factory {
        Json {
            isLenient = true
            prettyPrint = true
            ignoreUnknownKeys = true
        }
    }
    factoryOf(::GetUserRoutingImpl) { bind<GetUserRouting>() }
    factoryOf(::UpdateUserRoutingImpl) { bind<UpdateUserRouting>() }
}