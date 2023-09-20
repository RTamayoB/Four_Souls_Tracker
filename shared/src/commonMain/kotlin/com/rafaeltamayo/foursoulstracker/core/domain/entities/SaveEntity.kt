package com.rafaeltamayo.foursoulstracker.core.domain.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SaveEntity(
    @SerialName("id")
    val id: Long,
    @SerialName("save_name")
    val name: String,
    @SerialName("is_alive")
    val isAlive: Boolean = true,
    @SerialName("hp")
    val hp: Int = 2,
    @SerialName("damage")
    val damage: Int = 1,
    @SerialName("dice_modifier")
    val dice: Int = 0,
    @SerialName("souls")
    val souls: Int = 0
)
