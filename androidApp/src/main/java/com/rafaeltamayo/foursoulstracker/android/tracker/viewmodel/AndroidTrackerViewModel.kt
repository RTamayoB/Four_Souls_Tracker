package com.rafaeltamayo.foursoulstracker.android.tracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaeltamayo.foursoulstracker.core.data.repositories.TrackerRepository
import com.rafaeltamayo.foursoulstracker.tracker.presentation.TrackerEvent
import com.rafaeltamayo.foursoulstracker.tracker.presentation.TrackerViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidTrackerViewModel @Inject constructor(
    private val trackerRepository: TrackerRepository,
):ViewModel(){

    private val viewModel by lazy {
        TrackerViewModel(
            coroutineScope = viewModelScope,
            trackerRepository = trackerRepository
        )
    }

    val state = viewModel.state

    fun onEvent(event: TrackerEvent) {
        viewModel.onEvent(event)
    }
}