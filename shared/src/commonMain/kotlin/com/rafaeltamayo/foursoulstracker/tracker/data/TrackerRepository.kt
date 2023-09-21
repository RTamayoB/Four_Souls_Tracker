package com.rafaeltamayo.foursoulstracker.tracker.data

import com.rafaeltamayo.foursoulstracker.core.domain.util.CommonFlow
import com.rafaeltamayo.foursoulstracker.tracker.domain.TrackerDataSource
import com.rafaeltamayo.foursoulstracker.tracker.domain.models.CounterItem
import com.rafaeltamayo.foursoulstracker.tracker.domain.models.SaveItem

class TrackerRepository(
    private val dataSource: TrackerDataSource
) {

    fun getSaves(): CommonFlow<List<SaveItem>> {
        return dataSource.getSaves()
    }

    suspend fun insertCounter(saveItem: SaveItem) {
        dataSource.insertSave(saveItem)
    }
}