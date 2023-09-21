package com.rafaeltamayo.foursoulstracker.tracker.domain.models

import database.Saves
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class SaveItem(
    val id: Long,
    val name: String,
    val isAlive: Boolean? = true,
    val hp: Int = 2,
    val damage: Int = 1,
    val dice: Int = 0,
    val souls: Int = 0
)


fun Saves.toSaveItem(): SaveItem {
    return SaveItem(
        id = id,
        name = name,
        isAlive = is_alive,
        hp = hp.toInt(),
        dice = dice_modifier.toInt(),
        damage = damage.toInt(),
        souls = souls.toInt()
    )
}

fun List<Saves>.toSaveItems(): List<SaveItem> {
    return map { it.toSaveItem() }
}