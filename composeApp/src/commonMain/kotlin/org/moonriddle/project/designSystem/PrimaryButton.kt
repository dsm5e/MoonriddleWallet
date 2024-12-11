package org.moonriddle.project.designSystem

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(55.dp)
            .padding(horizontal = 16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = AppColors.PrimaryGreen)
    ) {
        Text(
            text = text,
            color = AppColors.DarkBackground,
            fontSize = 18.sp
        )
    }
}