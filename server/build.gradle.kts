plugins {
    application
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.kotlinSerialization)
}

group = "com.unomather.tgifts"
version = "1.0.0"
application {
    mainClass.set("com.unomather.tgifts.server.ApplicationKt")
    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
    implementation(libs.bundles.base)
    implementation(libs.bundles.database)
    implementation(libs.bundles.coroutines)
    implementation(libs.bundles.koin)
    implementation(libs.bundles.server)
    implementation(libs.bundles.cryptography)
}