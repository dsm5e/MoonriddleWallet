package org.moonriddle.project.features.main.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.moonriddle.project.core.navigation.MainTab
import org.moonriddle.project.designSystem.AppColors

@Composable
fun MainScreen(
    selectedTab: MainTab,
    onTabSelected: (MainTab) -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.height(80.dp), // Увеличиваем высоту (50dp + 30dp)
                backgroundColor = Color.Black, // Цвет фона
                contentColor = AppColors.PrimaryGreen // Цвет контента (иконки и текст)
            ) {
                MainTab.values().forEach { tab ->
                    BottomNavigationItem(
                        selected = selectedTab == tab,
                        onClick = { onTabSelected(tab) },
                        icon = {
                            Icon(
                                imageVector = tab.icon,
                                contentDescription = tab.title,
                                tint = if (selectedTab == tab) AppColors.PrimaryGreen else AppColors.FontSecondary
                            )
                        },
                        label = {
                            Text(
                                text = tab.title,
                                color = if (selectedTab == tab) AppColors.PrimaryGreen else AppColors.FontSecondary
                            )
                        },
                        selectedContentColor = AppColors.PrimaryGreen, // Цвет при выборе
                        unselectedContentColor = AppColors.FontSecondary, // Цвет для невыбранных
                        alwaysShowLabel = true, // Всегда показывать подписи
                        interactionSource = NoRippleInteractionSource() // Отключаем анимацию нажатия
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            when (selectedTab) {
                MainTab.Home -> Text("Главный экран")
                MainTab.Transactions -> Text("Ваши транзакции")
                MainTab.Settings -> Text("Настройки")
            }
        }
    }
}

@Composable
fun NoRippleInteractionSource() = remember {
    object : androidx.compose.foundation.interaction.MutableInteractionSource {
        override val interactions = kotlinx.coroutines.flow.emptyFlow<androidx.compose.foundation.interaction.Interaction>()

        override suspend fun emit(interaction: androidx.compose.foundation.interaction.Interaction) {}
        override fun tryEmit(interaction: androidx.compose.foundation.interaction.Interaction) = true
    }
}