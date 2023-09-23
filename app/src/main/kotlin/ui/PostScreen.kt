package fr.nicopico.kmp.jsonplaceholder.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import fr.nicopico.kmp.jsonplaceholder.api.JSONPlaceholderApi
import fr.nicopico.kmp.jsonplaceholder.api.models.Post
import fr.nicopico.kmp.jsonplaceholder.api.models.PostId
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun PostScreen() {
    Column(Modifier.fillMaxWidth().padding(8.dp)) {
        var posts: List<Post>? by remember { mutableStateOf(emptyList()) }

        // Call JSONPlaceholder API to retrieve a list of posts
        val jsonPlaceholderApi = koinInject<JSONPlaceholderApi>()
        val scope = rememberCoroutineScope()

        Text("Posts")
        Button(
            content = { Text("Load") },
            onClick = {
                posts = null
                scope.launch {
                    posts = jsonPlaceholderApi.getPosts()
                }
            }
        )
        PostList(
            Modifier.fillMaxWidth(),
            loading = posts == null,
            posts = posts ?: emptyList(),
        )
    }
}

@Composable
private fun PostList(
    modifier: Modifier = Modifier,
    loading: Boolean,
    posts: List<Post>,
) {
    if (loading) {
        LinearProgressIndicator(Modifier.fillMaxWidth())
    } else {
        LazyColumn(modifier) {
            items(posts) { post ->
                PostCard(
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    post
                )
            }
        }
    }
}

@Preview
@Composable
private fun PostCard(
    modifier: Modifier = Modifier,
    @PreviewParameter(PostPreviewParameterProvider::class)
    post: Post
) {
    Card(modifier) {
        Column(Modifier.padding(8.dp)) {
            Text(
                post.title,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Bold
            )
            Text(
                post.body,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

private class PostPreviewParameterProvider : PreviewParameterProvider<Post> {
    override val values: Sequence<Post>
        get() = sequenceOf(
            Post(
                id = PostId(1),
                userId = 1,
                title = "Lorem",
                body = "bla bla bbbllaal ldlsdks khqksfks fhkjsdfn ndsfhjskfh ksnd ",
            ),
            Post(
                id = PostId(3),
                userId = 1,
                title = "Lorem Ipsum",
                body = "The grey fox leaps above the ground",
            ),
        )

}
