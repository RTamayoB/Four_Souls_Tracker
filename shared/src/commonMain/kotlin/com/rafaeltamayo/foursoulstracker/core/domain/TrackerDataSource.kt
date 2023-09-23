package com.rafaeltamayo.foursoulstracker.core.domain

import com.rafaeltamayo.foursoulstracker.core.domain.util.CommonFlow
import com.rafaeltamayo.foursoulstracker.core.domain.models.CounterItem
import com.rafaeltamayo.foursoulstracker.core.domain.models.SaveItem

interface TrackerDataSource {

    fun getSaves(): CommonFlow<List<SaveItem>>

    fun getSaveById(id: Long): CommonFlow<SaveItem?>

    suspend fun insertSave(save: SaveItem)

    fun getCounters(): CommonFlow<List<CounterItem>>

    suspend fun insertCounter(counter: CounterItem)
    suspend fun updateCounter(counter: CounterItem)
}