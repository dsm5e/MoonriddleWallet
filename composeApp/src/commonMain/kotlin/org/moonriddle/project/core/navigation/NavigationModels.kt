package org.moonriddle.project.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen {
    object Onboarding: Screen()
    object Start: Screen()
    object CreateAccount: Screen()
    object ImportAccount: Screen()
    data class Main(val selectedTab: MainTab): Screen()
}

enum class MainTab(
    val title: String,
    val icon: ImageVector
) {
    Home("Главная", Icons.Default.Home),
    Transactions("Сканер", Icons.Default.List),
    Settings("Настройки", Icons.Default.Settings),
}

data class NavigationState(
    val currentScreen: Screen = Screen.Onboarding,
    val screenStack: List<Screen> = listOf(Screen.Onboarding)
)

sealed class NavigationEvent {
    data class NavigateTo(val screen: Screen) : NavigationEvent()
    object NavigateBack : NavigationEvent()
}
