package com.unomather.tgifts.firebase.di

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.database.FirebaseDatabase
import com.unomather.tgifts.firebase.data.AddApplicationUseCaseImpl
import com.unomather.tgifts.firebase.domain.AddApplicationUseCase
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val moduleFirebase = module {
    /**
     * FIREBASE INIT
     */
    single {
        val url = "https://auto-accept-56c6c-default-rtdb.europe-west1.firebasedatabase.app/"
        val credentials = Thread.currentThread().contextClassLoader
            ?.getResourceAsStream("serviceAccountKey.json")
            ?.use { GoogleCredentials.fromStream(it) }
            ?: throw IllegalStateException("No GoogleCredentials.fromStream() found")
        val options = FirebaseOptions.builder()
            .setCredentials(credentials)
            .setDatabaseUrl(url)
            .build()
        FirebaseApp.initializeApp(options)
    }
    /**
     * DATABASE
     */
    single<FirebaseDatabase> { FirebaseDatabase.getInstance(get<FirebaseApp>()) }
    /**
     * ADD APPLICATION
     */
    factoryOf(::AddApplicationUseCaseImpl) { bind<AddApplicationUseCase>() }
}