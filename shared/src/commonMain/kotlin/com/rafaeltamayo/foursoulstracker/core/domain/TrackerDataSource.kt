package com.rafaeltamayo.foursoulstracker.core.domain

import com.rafaeltamayo.foursoulstracker.core.domain.util.CommonFlow
import com.rafaeltamayo.foursoulstracker.core.domain.models.CounterItem
import com.rafaeltamayo.foursoulstracker.core.domain.models.SaveItem

interface TrackerDataSource {

    fun getSaves(): CommonFlow<List<SaveItem>>

    fun getSaveById(id: Long): CommonFlow<SaveItem?>

    suspend fun insertOrReplaceSave(save: SaveItem)

    suspend fun updateSave(save: SaveItem)

    suspend fun deleteSave(saveId: Long)

    fun getCountersBySaveId(saveId: Long): CommonFlow<CounterItem?>

    suspend fun insertOrReplaceCounter(counter: CounterItem)

    suspend fun deleteCounter(counterId: Long)
}