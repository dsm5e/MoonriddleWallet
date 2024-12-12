package org.moonriddle.project

import androidx.compose.ui.window.ComposeUIViewController
import org.moonriddle.project.core.App
import org.moonriddle.project.core.navigation.NavigationStore

fun MainViewController() = ComposeUIViewController {
    val navigationStore = NavigationStore()
    App(navigationStore)
}