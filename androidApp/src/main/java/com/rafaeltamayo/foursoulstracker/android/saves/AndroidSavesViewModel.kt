package com.rafaeltamayo.foursoulstracker.android.saves

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rafaeltamayo.foursoulstracker.core.data.repositories.TrackerRepository
import com.rafaeltamayo.foursoulstracker.saves.presentation.SavesEvent
import com.rafaeltamayo.foursoulstracker.saves.presentation.SavesViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidSavesViewModel @Inject constructor(
    private val trackerRepository: TrackerRepository
): ViewModel() {

    private val viewModel by lazy {
        SavesViewModel(
            coroutineScope = viewModelScope,
            trackerRepository = trackerRepository
        )
    }

    val state = viewModel.state

    fun onEvent(event: SavesEvent) {
        viewModel.onEvent(event)
    }
}