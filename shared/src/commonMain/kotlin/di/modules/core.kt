package fr.nicopico.kmp.jsonplaceholder.di.modules

import co.touchlab.kermit.Logger
import co.touchlab.kermit.StaticConfig
import co.touchlab.kermit.platformLogWriter
import kotlinx.datetime.Clock
import org.koin.dsl.module

internal val coreModule = module {
    single<Clock> {
        Clock.System
    }

    // platformLogWriter() is a relatively simple config option, useful for local debugging. For production
    // uses you *may* want to have a more robust configuration from the native platform that would likely
    // go into platformModule expect/actual.
    // See https://github.com/touchlab/Kermit
    val baseLogger = Logger(
        config = StaticConfig(logWriterList = listOf(platformLogWriter())),
        "KMP"
    )
    factory { (tag: String?) ->
        if (tag != null) baseLogger.withTag(tag) else baseLogger
    }
}
