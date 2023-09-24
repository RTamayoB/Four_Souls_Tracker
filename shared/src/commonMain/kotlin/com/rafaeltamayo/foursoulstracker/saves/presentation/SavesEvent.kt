package com.rafaeltamayo.foursoulstracker.saves.presentation

import com.rafaeltamayo.foursoulstracker.core.presentation.models.UiSave

sealed class SavesEvent {
    data object CreateTestSave: SavesEvent()
    data object UpdateSave: SavesEvent()

    data class SelectSave(val save: UiSave): SavesEvent()
    data class DeselectSave(val save: UiSave): SavesEvent()
}