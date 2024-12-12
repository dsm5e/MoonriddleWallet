package org.moonriddle.project.features.onboarding.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.moonriddle.project.designSystem.AppColors
import org.moonriddle.project.designSystem.PrimaryButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import moonriddlewallet.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource

@Composable
fun OnboardingScreen(
    onFinish: () -> Unit
) {
    var currentPage by remember { mutableStateOf(0) }

    val pages = listOf(
        "Добро пожаловать в наш XRPL кошелек! Управляйте своими XRP активами.",
        "Подписывайте транзакции безопасно и проверяйте баланс в реальном времени.",
        "Легко переключайтесь между разными аккаунтами и делайте переводы."
    )

    val images = listOf(
        Res.drawable.onboarding1,
        Res.drawable.onboarding2,
        Res.drawable.onboarding3
    )

    Column(
        modifier = Modifier
            .background(AppColors.DarkBackground)
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(120.dp))

        Text(
            text = pages[currentPage],
            style = MaterialTheme.typography.h6,
            color = AppColors.FontPrimary
        )

        Spacer(modifier = Modifier.height(120.dp))

        Image(
            painter = painterResource(images[currentPage]),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(16.dp)) // Укажите желаемый радиус
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.weight(1f))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            repeat(3) { index ->
                val color = if (index == currentPage) AppColors.PrimaryGreen else AppColors.FontSecondary
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Surface(
                        shape = CircleShape,
                        color = color
                    ) {
                        Box(modifier = Modifier.size(24.dp))
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        PrimaryButton(
            text = if (currentPage == pages.size - 1) "Начать" else "Далее",
            modifier = Modifier.padding(bottom = 30.dp),
            onClick = {
                if (currentPage < pages.size - 1) {
                    currentPage += 1
                } else {
                    onFinish()
                }
            }
        )
    }
}