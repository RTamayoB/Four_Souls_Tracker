package com.rafaeltamayo.foursoulstracker.core.domain.models

import database.Saves

data class SaveEntity(
    val id: Long?,
    val name: String,
    val isAlive: Boolean,
    val hp: Int,
    val damage: Int,
    val dice: Int,
    val souls: Int
)


fun Saves.toSaveEntity(): SaveEntity {
    return SaveEntity(
        id = id,
        name = name,
        isAlive = is_alive ?: false,
        hp = hp.toInt(),
        dice = dice_modifier.toInt(),
        damage = damage.toInt(),
        souls = souls.toInt()
    )
}

fun List<Saves>.toSaveEntities(): List<SaveEntity> {
    return map { it.toSaveEntity() }
}