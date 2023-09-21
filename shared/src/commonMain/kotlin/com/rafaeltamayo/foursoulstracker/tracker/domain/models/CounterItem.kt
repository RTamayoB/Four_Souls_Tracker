package com.rafaeltamayo.foursoulstracker.tracker.domain.models

import database.Counters
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class CounterItem(
    val id: Long,
    val saveId: Long,
    val name: String,
    val value: Int = 0
)


fun Counters.toCounterItem(): CounterItem {
    return CounterItem(
        id = id,
        saveId = save_id,
        name = name,
        value = value_.toInt()
    )
}

fun List<Counters>.toCounterItems(): List<CounterItem> {
    return map { it.toCounterItem() }
}