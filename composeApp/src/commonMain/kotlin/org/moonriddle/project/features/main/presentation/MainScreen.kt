package org.moonriddle.project.features.main.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.moonriddle.project.core.navigation.MainTab

@Composable
fun MainScreen(
    selectedTab: MainTab,
    onTabSelected: (MainTab) -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    selected = selectedTab == MainTab.Home,
                    onClick = { onTabSelected(MainTab.Home) },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") }
                )
                BottomNavigationItem(
                    selected = selectedTab == MainTab.Transactions,
                    onClick = { onTabSelected(MainTab.Transactions) },
                    icon = { Icon(Icons.Default.List, contentDescription = "Transactions") },
                    label = { Text("Transactions") }
                )
                BottomNavigationItem(
                    selected = selectedTab == MainTab.Settings,
                    onClick = { onTabSelected(MainTab.Settings) },
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                    label = { Text("Settings") }
                )
                BottomNavigationItem(
                    selected = selectedTab == MainTab.Profile,
                    onClick = { onTabSelected(MainTab.Profile) },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") }
                )
            }
        }
    ) { innerPadding ->
        // Здесь можете отрисовать контент выбранной вкладки.
        // Например, упрощённо:
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize()) {
            when (selectedTab) {
                MainTab.Home -> Text("Главный экран")
                MainTab.Transactions -> Text("Ваши транзакции")
                MainTab.Settings -> Text("Настройки")
                MainTab.Profile -> Text("Профиль")
            }
        }
    }
}