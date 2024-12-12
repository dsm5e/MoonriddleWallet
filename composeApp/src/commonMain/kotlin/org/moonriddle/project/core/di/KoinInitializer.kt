package org.moonriddle.project.core.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            appModule // Добавьте ваши модули Koin
        )
    }
}