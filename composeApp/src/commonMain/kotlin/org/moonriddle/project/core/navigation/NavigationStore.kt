package org.moonriddle.project.core.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NavigationStore {
    private val _navigationState = MutableStateFlow(NavigationState())
    val navigationState: StateFlow<NavigationState> = _navigationState

    fun handleEvent(event: NavigationEvent) {
        val current = _navigationState.value
        when (event) {
            is NavigationEvent.NavigateTo -> {
                _navigationState.value = current.copy(currentScreen = event.screen)
            }
            NavigationEvent.NavigateBack -> {

            }
        }
    }
}