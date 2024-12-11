package org.moonriddle.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform