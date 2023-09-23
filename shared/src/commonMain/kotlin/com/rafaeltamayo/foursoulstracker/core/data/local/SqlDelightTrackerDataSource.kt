package com.rafaeltamayo.foursoulstracker.core.data.local

import com.rafaeltamayo.foursoulstracker.core.domain.util.CommonFlow
import com.rafaeltamayo.foursoulstracker.core.domain.util.toCommonFlow
import com.rafaeltamayo.foursoulstracker.database.FourSoulsTrackerDatabase
import com.rafaeltamayo.foursoulstracker.core.domain.TrackerDataSource
import com.rafaeltamayo.foursoulstracker.core.domain.models.CounterItem
import com.rafaeltamayo.foursoulstracker.core.domain.models.SaveItem
import com.rafaeltamayo.foursoulstracker.core.domain.models.toCounterItem
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

    override suspend fun insertOrReplaceSave(save: SaveItem) {
        queries.insertSave(
            id = null,
            name = save.name,
            is_alive = save.isAlive,
            hp = save.hp.toLong(),
            damage = save.damage.toLong(),
            dice_modifier = save.dice.toLong(),
            souls = save.souls.toLong()
        )
    }

    override suspend fun updateSave(save: SaveItem) {
        save.id?.let {
            queries.updateSave(
                name = save.name,
                isAlive = save.isAlive,
                hp = save.hp.toLong(),
                damage = save.damage.toLong(),
                dice = save.dice.toLong(),
                souls = save.dice.toLong(),
                id = it
            )
        }
    }

    override suspend fun deleteSave(saveId: Long) {
        queries.deleteSave(saveId)
    }

    override fun getCountersBySaveId(saveId:Long): CommonFlow<CounterItem?> {
        return queries
            .getCountersBySaveId(saveId)
            .asFlow()
            .map {
                it.executeAsOneOrNull()?.toCounterItem()
            }
            .toCommonFlow()
    }

    override suspend fun insertOrReplaceCounter(counter: CounterItem) {
        queries.insertCounter(
            id = counter.id,
            save_id = counter.saveId,
            name = counter.name,
            value_ = counter.value.toLong()
        )
    }

    override suspend fun deleteCounter(counterId: Long) {
        queries.deleteCounterById(counterId)
    }
}