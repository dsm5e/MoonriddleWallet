package org.moonriddle.project.core.di

import org.koin.dsl.module
import org.moonriddle.project.features.main.domain.repository.MainRepository

val repositoryModule = module {
    single { MainRepository(get()) }
}