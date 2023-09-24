package com.rafaeltamayo.foursoulstracker.saves.presentation

import com.rafaeltamayo.foursoulstracker.core.presentation.models.UiSave

data class SavesState(
    val saves: List<UiSave> = emptyList(),
    val selectedSaves: List<UiSave> = emptyList()
)