package com.rafaeltamayo.foursoulstracker.tracker.data.local

import com.rafaeltamayo.foursoulstracker.core.domain.util.CommonFlow
import com.rafaeltamayo.foursoulstracker.core.domain.util.toCommonFlow
import com.rafaeltamayo.foursoulstracker.database.FourSoulsTrackerDatabase
import com.rafaeltamayo.foursoulstracker.tracker.domain.TrackerDataSource
import com.rafaeltamayo.foursoulstracker.tracker.domain.models.CounterItem
import com.rafaeltamayo.foursoulstracker.tracker.domain.models.SaveItem
import com.rafaeltamayo.foursoulstracker.tracker.domain.models.toSaveItem
import com.rafaeltamayo.foursoulstracker.tracker.domain.models.toSaveItems
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import database.Saves
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

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