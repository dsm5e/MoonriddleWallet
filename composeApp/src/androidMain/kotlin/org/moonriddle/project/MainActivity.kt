package org.moonriddle.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.koin.android.ext.android.inject
import org.moonriddle.project.core.App
import org.moonriddle.project.core.di.initKoin
import org.moonriddle.project.core.navigation.NavigationStore

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initKoin()

        val navigationStore: NavigationStore by inject()

        setContent {
            App(navigationStore = navigationStore)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val navigationStore = NavigationStore()
    App(navigationStore = navigationStore)
}