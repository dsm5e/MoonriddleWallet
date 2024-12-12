package org.moonriddle.project.features.account.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ImportAccountScreen(onBack: () -> Unit) {
    var seed by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Введите seed для восстановления", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(32.dp))
        TextField(
            value = seed,
            onValueChange = { seed = it },
            label = { Text("Seed") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = {
            // Добавить валидацию seed
        }) {
            Text("Восстановить")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onBack) {
            Text("Назад")
        }
    }
}