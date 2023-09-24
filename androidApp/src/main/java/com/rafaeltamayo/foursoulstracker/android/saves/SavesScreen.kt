package com.rafaeltamayo.foursoulstracker.android.saves

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaeltamayo.foursoulstracker.android.R
import com.rafaeltamayo.foursoulstracker.android.saves.components.SaveListItem
import com.rafaeltamayo.foursoulstracker.core.presentation.models.UiSave
import com.rafaeltamayo.foursoulstracker.saves.presentation.SavesEvent
import com.rafaeltamayo.foursoulstracker.saves.presentation.SavesState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavesScreen(
    state: SavesState,
    onEvent: (SavesEvent) -> Unit,
    onNavigateToSave: (UiSave) -> Unit,
    onNavigateToNewSave: () -> Unit
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
            LargeFloatingActionButton(onClick = onNavigateToNewSave) {
                Text(
                    text = "+",
                    style = MaterialTheme.typography.displayLarge,
                )
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Image(
                painter = painterResource(id = R.drawable.character_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            LazyColumn {
                items(state.saves) { save ->
                    SaveListItem(
                        uiSave = save,
                        isSelectionModeOn = state.selectedSaves.isNotEmpty(),
                        isSaveSelected = state.selectedSaves.contains(save),
                        onSelected = {
                            onEvent(SavesEvent.SelectSave(it))
                        },
                        onDeselected = {
                            onEvent(SavesEvent.DeselectSave(it))
                        },
                        onOpenSave = {
                            onNavigateToSave(it)
                        },
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SavesScreenPreview() {
    SavesScreen(
        state = SavesState(),
        onEvent = {},
        onNavigateToSave = {},
        onNavigateToNewSave = {}
    )
}