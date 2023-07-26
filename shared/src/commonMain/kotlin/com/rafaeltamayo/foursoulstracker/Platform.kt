package com.rafaeltamayo.foursoulstracker

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform