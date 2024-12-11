package org.moonriddle.project.accountFlow

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.moonriddle.project.designSystem.AppColors
import org.moonriddle.project.designSystem.PrimaryButton

@Composable
fun  StartScreen(
    onCreateAccount: () -> Unit,
    onImportAccount: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(AppColors.DarkBackground)
            .fillMaxSize()
            .systemBarsPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("MOONRIDDLE WALLET", color = AppColors.FontPrimary)

        Spacer(modifier = Modifier.height(40.dp))
        PrimaryButton(
            text = "Создать аккаунт",
            onClick = onCreateAccount
        )
        Spacer(modifier = Modifier.height(16.dp))
        PrimaryButton(
            text = "Добавить существующий",
            onClick = onImportAccount
        )
    }
}