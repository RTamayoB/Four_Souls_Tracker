package com.rafaeltamayo.foursoulstracker.android.saves

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.rafaeltamayo.foursoulstracker.core.presentation.models.UiSave
import com.rafaeltamayo.foursoulstracker.saves.presentation.SavesEvent
import com.rafaeltamayo.foursoulstracker.saves.presentation.SavesState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavesScreen(
    state: SavesState,
    onEvent: (SavesEvent) -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Fours Souls Tracker") },
                 colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                     containerColor = Color(0xFFFFC107)
                 )
            )
        },
        floatingActionButton = {
            Row {
                FloatingActionButton(onClick = { onEvent(SavesEvent.CreateTestSave) }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
                FloatingActionButton(onClick = { onEvent(SavesEvent.UpdateSave) }) {
                    Icon(imageVector = Icons.Default.Build, contentDescription = null)
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            items(state.saves) {
                SaveListItem(uiSave = it)
            }
        }
    }
}

@Composable
fun SaveListItem(uiSave: UiSave) {
    ListItem(
        headlineContent = {
            Text(
                text = "${uiSave.name} - ID:${uiSave.id}",
                style = MaterialTheme.typography.titleLarge
            )
        },
        supportingContent = {
            Text(
                text = "HP:${uiSave.hp} - DMG:${uiSave.damage} - DICE:${uiSave.dice} - SOULS:${uiSave.souls}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    )
}

@Preview
@Composable
fun SavesScreenPreview() {
    SavesScreen(
        state = SavesState(),
        onEvent = {}
    )
}