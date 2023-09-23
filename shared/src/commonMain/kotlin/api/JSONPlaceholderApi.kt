package fr.nicopico.kmp.jsonplaceholder.api

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import fr.nicopico.kmp.jsonplaceholder.api.models.Comment
import fr.nicopico.kmp.jsonplaceholder.api.models.Post
import fr.nicopico.kmp.jsonplaceholder.api.models.PostId

public interface JSONPlaceholderApi {

    @GET("posts")
    public suspend fun getPosts(): List<Post>

    @GET("posts/{postId}/")
    public suspend fun getPostById(@Path("postId") postId: PostId): Post

    @GET("posts/{postId}/comments")
    public suspend fun getComments(@Path("postId") postId: PostId): List<Comment>

    public companion object {
        public const val BASE_URL: String = "https://jsonplaceholder.typicode.com/"
    }
}
