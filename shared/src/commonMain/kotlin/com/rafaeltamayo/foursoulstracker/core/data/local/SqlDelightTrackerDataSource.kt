package com.rafaeltamayo.foursoulstracker.core.data.local

import com.rafaeltamayo.foursoulstracker.core.domain.util.CommonFlow
import com.rafaeltamayo.foursoulstracker.core.domain.util.toCommonFlow
import com.rafaeltamayo.foursoulstracker.database.FourSoulsTrackerDatabase
import com.rafaeltamayo.foursoulstracker.core.domain.TrackerDataSource
import com.rafaeltamayo.foursoulstracker.core.domain.models.CounterItem
import com.rafaeltamayo.foursoulstracker.core.domain.models.SaveItem
import com.rafaeltamayo.foursoulstracker.core.domain.models.toSaveItem
import com.rafaeltamayo.foursoulstracker.core.domain.models.toSaveItems
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class SqlDelightTrackerDataSource(
    db: FourSoulsTrackerDatabase
): TrackerDataSource {

    private val queries = db.fourSoulsTrackerDatabaseQueries
    override fun getSaves(): CommonFlow<List<SaveItem>> {
        return queries
            .getSaves()
            .asFlow()
            .mapToList()
            .map { saves ->
                saves.toSaveItems()
            }
            .toCommonFlow()
    }

    override fun getSaveById(id: Long): CommonFlow<SaveItem?> {
        return flowOf(queries.getSaveById(id).executeAsOneOrNull()?.toSaveItem()).toCommonFlow()
    }

    override suspend fun insertSave(save: SaveItem) {
        queries.insertSave(
            id = save.id,
            name = save.name,
            is_alive = save.isAlive,
            hp = save.hp.toLong(),
            damage = save.damage.toLong(),
            dice_modifier = save.dice.toLong(),
            souls = save.souls.toLong()
        )
    }

    override fun getCounters(): CommonFlow<List<CounterItem>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertCounter(counter: CounterItem) {
        TODO("Not yet implemented")
    }

    override suspend fun updateCounter(counter: CounterItem) {
        TODO("Not yet implemented")
    }
}