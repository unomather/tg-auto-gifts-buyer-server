package com.unomather.tgifts.database.di

import com.unomather.tgifts.database.data.GetUserUseCaseImpl
import com.unomather.tgifts.database.data.UpdateUserUseCaseImpl
import com.unomather.tgifts.database.domain.GetUserUseCase
import com.unomather.tgifts.database.domain.UpdateUserUseCase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val moduleDatabase = module {
    factoryOf(::GetUserUseCaseImpl) { bind<GetUserUseCase>() }
    factoryOf(::UpdateUserUseCaseImpl) { bind<UpdateUserUseCase>() }
}