package com.rafaeltamayo.foursoulstracker.core.data.local

import com.rafaeltamayo.foursoulstracker.core.data.database.DatabaseDriverFactory
import com.rafaeltamayo.foursoulstracker.core.domain.entities.SaveEntity
import com.rafaeltamayo.foursoulstracker.database.FourSoulsTrackerDatabase
import database.Saves

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = FourSoulsTrackerDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.fourSoulsTrackerDatabaseQueries

    internal fun getAllSaves(): List<SaveEntity> {
        val saveEntities = dbQuery.getSaves().executeAsList().map { it.toSaveEntity() }
        return saveEntities
    }

    private fun Saves.toSaveEntity(): SaveEntity {
        return SaveEntity(
            id = id,
            name = name,
            isAlive = is_alive ?: false,
            hp = hp.toInt(),
            damage = damage.toInt(),
            dice = dice_modifier.toInt(),
            souls = souls.toInt()
        )
    }

    internal fun createSave(save: SaveEntity) {
        dbQuery.insertSave(
            save.id,
            save.name,
            save.isAlive,
            save.hp.toLong(),
            save.damage.toLong(),
            save.dice.toLong(),
            save.souls.toLong()
        )
    }
}