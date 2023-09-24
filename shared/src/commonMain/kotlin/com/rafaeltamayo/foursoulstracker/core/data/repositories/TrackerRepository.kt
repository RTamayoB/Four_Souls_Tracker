package com.rafaeltamayo.foursoulstracker.core.data.repositories

import com.rafaeltamayo.foursoulstracker.core.domain.util.CommonFlow
import com.rafaeltamayo.foursoulstracker.core.domain.TrackerDataSource
import com.rafaeltamayo.foursoulstracker.core.domain.models.CounterEntity
import com.rafaeltamayo.foursoulstracker.core.domain.models.SaveEntity

class TrackerRepository(
    private val dataSource: TrackerDataSource
) {

    fun getSaves(): CommonFlow<List<SaveEntity>> {
        return dataSource.getSaves()
    }

    fun getSaveById(saveId: Long): CommonFlow<SaveEntity?> {
        return dataSource.getSaveById(saveId)
    }

    suspend fun insertOrReplaceSave(saveEntity: SaveEntity) {
        return dataSource.insertOrReplaceSave(saveEntity)
    }

    suspend fun updateSave(saveEntity: SaveEntity) {
        return dataSource.updateSave(saveEntity)
    }

    suspend fun deleteSave(saveId: Long) {
        return dataSource.deleteSave(saveId)
    }

    fun getCountersBySaveId(saveId: Long): CommonFlow<CounterEntity?> {
        return dataSource.getCountersBySaveId(saveId)
    }

    suspend fun insertOrReplaceCounter(counterEntity: CounterEntity) {
        return dataSource.insertOrReplaceCounter(counterEntity)
    }

    suspend fun deleteCounter(counterId: Long) {
        return dataSource.deleteCounter(counterId)
    }
}