package org.moonriddle.project.core

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform