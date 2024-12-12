package org.moonriddle.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.moonriddle.project.core.App
import org.moonriddle.project.core.navigation.NavigationStore

class MainActivity : ComponentActivity() {
    private val navigationStore = NavigationStore()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(navigationStore = navigationStore)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val previewNavigationStore = NavigationStore()
    App(navigationStore = previewNavigationStore)
}