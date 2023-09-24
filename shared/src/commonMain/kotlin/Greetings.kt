package fr.nicopico.kmp.jsonplaceholder

import co.touchlab.skie.configuration.annotations.DefaultArgumentInterop

public object Greetings {
    @DefaultArgumentInterop.Enabled
    public fun greet(name: String = "World"): String = "Hello $name!"
}
