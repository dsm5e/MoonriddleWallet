package org.moonriddle.project.core.di

import org.koin.dsl.module
import org.moonriddle.project.core.navigation.NavigationStore

val appModule = module {
    single { NavigationStore() }
}