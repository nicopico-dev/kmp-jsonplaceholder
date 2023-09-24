package fr.nicopico.kmp.jsonplaceholder.di

import fr.nicopico.kmp.jsonplaceholder.api.JSONPlaceholderApi
import org.koin.core.Koin

// Called from Swift
@Suppress("unused")
public val Koin.jsonPlaceholderApi: JSONPlaceholderApi
    get() = get<JSONPlaceholderApi>()
