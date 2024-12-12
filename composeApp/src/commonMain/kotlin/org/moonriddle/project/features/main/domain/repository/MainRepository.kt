package org.moonriddle.project.features.main.domain.repository

import io.ktor.client.HttpClient

class MainRepository(private val client: HttpClient) {
    fun getData(): String {
        // Вызов API или другая логика
        return "Repository data"
    }
}