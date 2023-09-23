package com.rafaeltamayo.foursoulstracker.saves.presentation

import database.Saves

sealed class SavesEvent {
    data object CreateTestSave: SavesEvent()
    data object UpdateSave: SavesEvent()
}