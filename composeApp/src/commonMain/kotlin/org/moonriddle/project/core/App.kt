package org.moonriddle.project.core

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.moonriddle.project.core.navigation.NavigationEvent
import org.moonriddle.project.core.navigation.NavigationStore
import org.moonriddle.project.core.navigation.Screen
import org.moonriddle.project.features.account.presentation.StartScreen
import org.moonriddle.project.features.account.presentation.CreateAccountScreen
import org.moonriddle.project.features.account.presentation.ImportAccountScreen
import org.moonriddle.project.features.main.presentation.MainScreen
import org.moonriddle.project.features.onboarding.presentation.OnboardingScreen

@Composable
@Preview
fun App(navigationStore: NavigationStore) {
    val state by navigationStore.navigationState.collectAsState()

    when (val screen = state.currentScreen) {
        Screen.Onboarding -> OnboardingScreen(
            onFinish = {
                navigationStore.handleEvent(NavigationEvent.NavigateTo(Screen.Start))
            }
        )
        Screen.Start -> StartScreen(
            onCreateAccount = { navigationStore.handleEvent(NavigationEvent.NavigateTo(Screen.CreateAccount)) },
            onImportAccount = { navigationStore.handleEvent(NavigationEvent.NavigateTo(Screen.ImportAccount)) }
        )
        Screen.CreateAccount -> CreateAccountScreen {  }
        Screen.ImportAccount -> ImportAccountScreen {  }
        is Screen.Main -> MainScreen(
            selectedTab = screen.selectedTab,
            onTabSelected = { newTab ->
                navigationStore.handleEvent(NavigationEvent.NavigateTo(Screen.Main(newTab)))
            }
        )
    }
}
