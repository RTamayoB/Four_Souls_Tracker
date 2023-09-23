package com.rafaeltamayo.foursoulstracker.core.domain.models

import database.Saves

data class SaveItem(
    val id: Long?,
    val name: String,
    val isAlive: Boolean,
    val hp: Int,
    val damage: Int,
    val dice: Int,
    val souls: Int
)


fun Saves.toSaveItem(): SaveItem {
    return SaveItem(
        id = id,
        name = name,
        isAlive = is_alive ?: false,
        hp = hp.toInt(),
        dice = dice_modifier.toInt(),
        damage = damage.toInt(),
        souls = souls.toInt()
    )
}

fun List<Saves>.toSaveItems(): List<SaveItem> {
    return map { it.toSaveItem() }
}