package fr.nicopico.kmp.jsonplaceholder.api.models

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@Serializable
@JvmInline
public value class PostId(
    internal val id: Int,
)
