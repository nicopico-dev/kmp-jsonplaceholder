package fr.nicopico.kmp.jsonplaceholder.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import fr.nicopico.kmp.jsonplaceholder.android.ui.GreetingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingScreen()
        }
    }
}
