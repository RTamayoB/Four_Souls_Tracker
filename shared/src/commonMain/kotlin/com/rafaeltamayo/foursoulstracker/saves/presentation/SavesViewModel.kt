package com.rafaeltamayo.foursoulstracker.saves.presentation

import com.rafaeltamayo.foursoulstracker.core.data.repositories.TrackerRepository
import com.rafaeltamayo.foursoulstracker.core.presentation.models.UiSave
import com.rafaeltamayo.foursoulstracker.core.presentation.models.toSaveItem
import com.rafaeltamayo.foursoulstracker.core.presentation.models.toUISaves
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SavesViewModel(
    coroutineScope: CoroutineScope?,
    private val trackerRepository: TrackerRepository
) {

    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _state = MutableStateFlow(SavesState())
    val state = _state

    init {
        viewModelScope.launch {
            trackerRepository.getSaves().collect { saveItemList ->
                _state.update {
                    it.copy(
                        saves = saveItemList.toUISaves()
                    )
                }
            }
        }
    }

    fun onEvent(event: SavesEvent) {
        when (event) {
            SavesEvent.CreateTestSave -> {
                val uiSave = UiSave(
                    name = "Test Save",
                )
                viewModelScope.launch {
                    trackerRepository.insertOrReplaceSave(uiSave.toSaveItem())
                }
            }

            SavesEvent.UpdateSave -> {
                val updatedSave = UiSave(
                    id = 1,
                    name = "Save Updated"
                )
                viewModelScope.launch {
                    trackerRepository.updateSave(updatedSave.toSaveItem())
                }
            }
        }
    }
}