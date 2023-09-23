package com.rafaeltamayo.foursoulstracker.tracker.presentation

import com.rafaeltamayo.foursoulstracker.core.data.repositories.TrackerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow

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