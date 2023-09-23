package com.rafaeltamayo.foursoulstracker.core.presentation.models

import com.rafaeltamayo.foursoulstracker.core.domain.models.SaveItem

data class UiSave(
     val id: Long? = 0,
    val name: String = "",
    val isAlive: Boolean? = true,
    val hp: Int = 2,
    val damage: Int = 1,
    val dice: Int = 0,
    val souls: Int = 0
)

fun SaveItem.toUISave(): UiSave {
    return UiSave(
        id = id,
        name = name,
        isAlive = isAlive,
        hp = hp,
        damage = damage,
        dice = dice,
        souls = souls
    )
}

fun List<SaveItem>.toUISaves(): List<UiSave> {
    return map { it.toUISave() }
}

fun UiSave.toSaveItem(): SaveItem {
    return SaveItem(
        id = id,
        name = name,
        isAlive = isAlive ?: false,
        hp = hp,
        damage = damage,
        dice = dice,
        souls = souls
    )
}