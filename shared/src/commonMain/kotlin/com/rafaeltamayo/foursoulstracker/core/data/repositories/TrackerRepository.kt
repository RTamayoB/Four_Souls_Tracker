package com.rafaeltamayo.foursoulstracker.core.data.repositories

import com.rafaeltamayo.foursoulstracker.core.domain.util.CommonFlow
import com.rafaeltamayo.foursoulstracker.core.domain.TrackerDataSource
import com.rafaeltamayo.foursoulstracker.core.domain.models.CounterItem
import com.rafaeltamayo.foursoulstracker.core.domain.models.SaveItem

class TrackerRepository(
    private val dataSource: TrackerDataSource
) {

    fun getSaves(): CommonFlow<List<SaveItem>> {
        return dataSource.getSaves()
    }

    fun getSaveById(saveId: Long): CommonFlow<SaveItem?> {
        return dataSource.getSaveById(saveId)
    }

    suspend fun insertOrReplaceSave(saveItem: SaveItem) {
        return dataSource.insertOrReplaceSave(saveItem)
    }

    suspend fun updateSave(saveItem: SaveItem) {
        return dataSource.updateSave(saveItem)
    }

    suspend fun deleteSave(saveId: Long) {
        return dataSource.deleteSave(saveId)
    }

    fun getCountersBySaveId(saveId: Long): CommonFlow<CounterItem?> {
        return dataSource.getCountersBySaveId(saveId)
    }

    suspend fun insertOrReplaceCounter(counterItem: CounterItem) {
        return dataSource.insertOrReplaceCounter(counterItem)
    }

    suspend fun deleteCounter(counterId: Long) {
        return dataSource.deleteCounter(counterId)
    }
}