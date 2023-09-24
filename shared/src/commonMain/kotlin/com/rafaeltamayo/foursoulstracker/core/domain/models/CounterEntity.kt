package com.rafaeltamayo.foursoulstracker.core.domain.models

import database.Counters

data class CounterEntity(
    val id: Long,
    val saveId: Long,
    val name: String,
    val value: Int = 0
)


fun Counters.toCounterEntity(): CounterEntity {
    return CounterEntity(
        id = id,
        saveId = save_id,
        name = name,
        value = value_.toInt()
    )
}

fun List<Counters>.toCounterEntities(): List<CounterEntity> {
    return map { it.toCounterEntity() }
}