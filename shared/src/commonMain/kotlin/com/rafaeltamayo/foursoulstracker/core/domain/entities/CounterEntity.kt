package com.rafaeltamayo.foursoulstracker.core.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CounterEntity(
    @SerialName("save_name")
    val saveName: String,
    @SerialName("counter_name")
    val counterName: String,
    @SerialName("value")
    val value: Int = 0
)
