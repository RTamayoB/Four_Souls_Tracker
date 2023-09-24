package com.rafaeltamayo.foursoulstracker.core.domain

import com.rafaeltamayo.foursoulstracker.core.domain.util.CommonFlow
import com.rafaeltamayo.foursoulstracker.core.domain.models.CounterEntity
import com.rafaeltamayo.foursoulstracker.core.domain.models.SaveEntity

interface TrackerDataSource {

    fun getSaves(): CommonFlow<List<SaveEntity>>

    fun getSaveById(id: Long): CommonFlow<SaveEntity?>

    suspend fun insertOrReplaceSave(save: SaveEntity)

    suspend fun updateSave(save: SaveEntity)

    suspend fun deleteSave(saveId: Long)

    fun getCountersBySaveId(saveId: Long): CommonFlow<CounterEntity?>

    suspend fun insertOrReplaceCounter(counter: CounterEntity)

    suspend fun deleteCounter(counterId: Long)
}