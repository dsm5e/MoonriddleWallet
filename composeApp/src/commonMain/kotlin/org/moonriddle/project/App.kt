package org.moonriddle.project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.moonriddle.project.accountFlow.StartScreen
import org.moonriddle.project.accountFlow.CreateAccountScreen
import org.moonriddle.project.accountFlow.ImportAccountScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        var currentScreen by remember { mutableStateOf("start") }

        when (currentScreen) {
            "start" -> StartScreen(
                onCreateAccount = { currentScreen = "create" },
                onImportAccount = { currentScreen = "import" }
            )
            "create" -> CreateAccountScreen(onBack = { currentScreen = "start" })
            "import" -> ImportAccountScreen(onBack = { currentScreen = "start" })
        }
    }
}
