package fr.nicopico.kmp.jsonplaceholder.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class Post(
    val id: PostId,
    val userId: Int,
    val title: String,
    val body: String,
)
