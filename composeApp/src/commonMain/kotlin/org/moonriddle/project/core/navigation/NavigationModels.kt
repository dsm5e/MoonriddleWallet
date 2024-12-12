package org.moonriddle.project.core.navigation

sealed class Screen {
    object Onboarding: Screen()
    object Start: Screen()
    object CreateAccount: Screen()
    object ImportAccount: Screen()
    data class Main(val selectedTab: MainTab): Screen()
}

enum class MainTab {
    Home, Transactions, Settings, Profile
}

data class NavigationState(
    val currentScreen: Screen = Screen.Onboarding
)

sealed class NavigationEvent {
    data class NavigateTo(val screen: Screen): NavigationEvent()
    object NavigateBack: NavigationEvent()
}