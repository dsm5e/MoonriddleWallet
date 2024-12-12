package org.moonriddle.project.core

import androidx.compose.runtime.*
import org.moonriddle.project.core.navigation.MainTab
import org.moonriddle.project.core.navigation.NavigationEvent
import org.moonriddle.project.core.navigation.NavigationStore
import org.moonriddle.project.core.navigation.Screen
import org.moonriddle.project.features.account.presentation.StartScreen
import org.moonriddle.project.features.account.presentation.CreateAccountScreen
import org.moonriddle.project.features.account.presentation.ImportAccountScreen
import org.moonriddle.project.features.main.presentation.MainScreen
import org.moonriddle.project.features.onboarding.presentation.OnboardingScreen

@Composable
fun App(navigationStore: NavigationStore) {
    val state by navigationStore.navigationState.collectAsState()

    val navigateTo: (Screen) -> Unit = { screen ->
        navigationStore.handleEvent(NavigationEvent.NavigateTo(screen))
    }

    val navigateBack: () -> Unit = {
        navigationStore.handleEvent(NavigationEvent.NavigateBack)
    }

    when (val screen = state.currentScreen) {
        Screen.Onboarding -> OnboardingScreen(onFinish = { navigateTo(Screen.Start) })
        Screen.Start -> StartScreen(
            onCreateAccount = { navigateTo(Screen.CreateAccount) },
            onImportAccount = { navigateTo(Screen.ImportAccount) }
        )
        Screen.CreateAccount -> CreateAccountScreen(
            onBack = { navigateBack() },
            onCreate = { navigateTo(Screen.Main(selectedTab = MainTab.Home)) }
        )
        Screen.ImportAccount -> ImportAccountScreen(onBack = { navigateBack() })
        is Screen.Main -> MainScreen(
            selectedTab = screen.selectedTab,
            onTabSelected = { newTab -> navigateTo(Screen.Main(newTab)) }
        )
    }
}