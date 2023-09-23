package fr.nicopico.kmp.jsonplaceholder.di

import fr.nicopico.kmp.jsonplaceholder.di.modules.apiModule
import fr.nicopico.kmp.jsonplaceholder.di.modules.coreModule
import fr.nicopico.kmp.jsonplaceholder.di.modules.platformModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

public fun initKoin(
    appConfig: KoinApplication.() -> Unit = {}
): KoinApplication {
    val koinApplication = startKoin {
        modules(
            apiModule,
            platformModule,
            coreModule,
        )
        appConfig()
    }
    return koinApplication
}
