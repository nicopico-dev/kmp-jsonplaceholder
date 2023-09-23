package fr.nicopico.kmp.jsonplaceholder.android.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.nicopico.kmp.jsonplaceholder.Greetings

@Preview
@Composable
fun GreetingScreen() {
    var name by remember { mutableStateOf("") }
    val greeting by remember {
        derivedStateOf { Greetings.greet(name) }
    }

    Column(Modifier.fillMaxWidth().padding(8.dp)) {
        TextField(
            value = name,
            label = { Text("What's your name ?") },
            onValueChange = { name = it },
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(Modifier.height(8.dp))
        Text(greeting)
    }
}
