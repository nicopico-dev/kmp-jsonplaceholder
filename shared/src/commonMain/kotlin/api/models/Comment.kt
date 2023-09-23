package fr.nicopico.kmp.jsonplaceholder.api.models

import kotlinx.serialization.Serializable

@Serializable
public data class Comment(
    val id: Int,
    val postId: PostId,
    val name: String,
    val email: String,
    val body: String,
)
