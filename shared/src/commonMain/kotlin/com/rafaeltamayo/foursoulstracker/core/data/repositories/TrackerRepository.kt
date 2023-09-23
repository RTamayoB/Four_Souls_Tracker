package com.rafaeltamayo.foursoulstracker.core.data.repositories

import com.rafaeltamayo.foursoulstracker.core.domain.util.CommonFlow
import com.rafaeltamayo.foursoulstracker.core.domain.TrackerDataSource
import com.rafaeltamayo.foursoulstracker.core.domain.models.SaveItem

class TrackerRepository(
    private val dataSource: TrackerDataSource
) {

    fun getSaves(): CommonFlow<List<SaveItem>> {
        return dataSource.getSaves()
    }

    fun getSaveById() {

    }

    fun insertSave(saveItem: SaveItem) {

    }

    fun updateSave(saveItem: SaveItem) {

    }

    fun deleteSave(saveId: Long) {

    }

    fun getCountersBySaveId() {

    }

    suspend fun insertCounter(saveItem: SaveItem) {
        dataSource.insertSave(saveItem)
    }

    suspend fun deleteCounter() {

    }
}