package org.moonriddle.project.features.account.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.moonriddle.project.designSystem.PrimaryButton

@Composable
fun CreateAccountScreen(onBack: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Создайте новый аккаунт", style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.height(32.dp))
        // Вставить реальную логику генерации аккаунта
        Text("Ваш Account ID: new_account_id_placeholder")
        Spacer(modifier = Modifier.height(32.dp))
        PrimaryButton(text = "Назад", onClick = onBack)
        Button(onClick = onBack) {
            Text("Назад")
        }
    }
}
