package org.moonriddle.project.core.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NavigationStore {
    private val _navigationState = MutableStateFlow(NavigationState())
    val navigationState: StateFlow<NavigationState> = _navigationState

    fun handleEvent(event: NavigationEvent) {
        val currentState = _navigationState.value
        when (event) {
            is NavigationEvent.NavigateTo -> navigateTo(event.screen)
            NavigationEvent.NavigateBack -> navigateBack()
        }
    }

    private fun navigateTo(screen: Screen) {
        val currentStack = _navigationState.value.screenStack
        _navigationState.value = NavigationState(
            currentScreen = screen,
            screenStack = currentStack + screen
        )
    }

    private fun navigateBack() {
        val currentStack = _navigationState.value.screenStack
        if (currentStack.size > 1) {
            val newStack = currentStack.dropLast(1)
            _navigationState.value = NavigationState(
                currentScreen = newStack.last(),
                screenStack = newStack
            )
        }
    }
}