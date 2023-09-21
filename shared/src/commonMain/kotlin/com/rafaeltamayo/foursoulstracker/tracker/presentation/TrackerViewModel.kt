package com.rafaeltamayo.foursoulstracker.tracker.presentation

import com.rafaeltamayo.foursoulstracker.tracker.data.TrackerRepository
import com.rafaeltamayo.foursoulstracker.tracker.domain.TrackerDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine

class TrackerViewModel(
    coroutineScope: CoroutineScope?,
    trackerRepository: TrackerRepository
) {

    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _state = MutableStateFlow(TrackerState())
    val state = _state

    fun onEvent(event: TrackerEvent) {

    }
}