package com.unomather.tgifts.database.di

import com.unomather.tgifts.database.data.gifts.GetUserUseCaseImpl
import com.unomather.tgifts.database.data.gifts.UpdateUserUseCaseImpl
import com.unomather.tgifts.database.domain.gifts.GetUserUseCase
import com.unomather.tgifts.database.domain.gifts.UpdateUserUseCase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val moduleDatabase = module {
    factoryOf(::GetUserUseCaseImpl) { bind<GetUserUseCase>() }
    factoryOf(::UpdateUserUseCaseImpl) { bind<UpdateUserUseCase>() }
}