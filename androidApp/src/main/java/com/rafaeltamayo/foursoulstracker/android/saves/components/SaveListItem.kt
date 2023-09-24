package com.rafaeltamayo.foursoulstracker.android.saves.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaeltamayo.foursoulstracker.android.R
import com.rafaeltamayo.foursoulstracker.android.core.ui.theme.FourSoulsTrackerTheme
import com.rafaeltamayo.foursoulstracker.core.presentation.models.UiSave

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SaveListItem(
    uiSave: UiSave,
    isSelectionModeOn: Boolean,
    isSaveSelected: Boolean,
    onSelected: (UiSave) -> Unit,
    onDeselected: (UiSave) -> Unit,
    onOpenSave: (UiSave) -> Unit,
    modifier: Modifier = Modifier
) {
    val haptics = LocalHapticFeedback.current
    val elevation by animateDpAsState(targetValue = if (isSaveSelected) 8.dp else 0.dp, label = "HomeItemElevation")

    Card(
        modifier = modifier
            .combinedClickable(
                onClick = {
                    if (isSaveSelected) {
                        onDeselected(uiSave)
                    } else {
                        if (isSelectionModeOn) {
                            onSelected(uiSave)
                        } else {
                            onOpenSave(uiSave)
                        }
                    }
                },
                onLongClick = {
                    haptics.performHapticFeedback(HapticFeedbackType.LongPress)
                    if (!isSelectionModeOn) {
                        onSelected(uiSave)
                    }
                }
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = elevation),
        //border = BorderStroke(border, MaterialTheme.colorScheme.onBackground)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.boi_item_background),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxWidth(),
                colorFilter = if (isSaveSelected) ColorFilter.tint(Color.White.copy(alpha = 0.6F), BlendMode.SrcAtop) else null
            )
            Column(Modifier.fillMaxWidth()) {
                val componentsPadding = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(vertical = 4.dp)
                Text(
                    text = uiSave.name,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = componentsPadding
                )
                Row(
                    modifier = componentsPadding.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    MiniStatComponent(icon = R.drawable.ic_action_heart, statText = " = ${uiSave.hp}")
                    MiniStatComponent(icon = R.drawable.ic_action_sword, statText = " = ${uiSave.damage}")
                    MiniStatComponent(icon = R.drawable.ic_action_dice, statText = " = ${uiSave.dice}")
                    MiniStatComponent(icon = R.drawable.ic_action_soul, statText = " = ${uiSave.souls}")
                }
                Text(
                    text = "Last updated: 12/07/2023",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = componentsPadding
                        .wrapContentWidth()
                        .align(Alignment.End)
                )
            }

        }
    }
}

@Composable
fun MiniStatComponent(
    @DrawableRes icon: Int,
    statText: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = statText,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun SaveListItemPreview() {
    FourSoulsTrackerTheme {
        SaveListItem(
            uiSave = UiSave(name = "Game Save"),
            isSelectionModeOn = false,
            isSaveSelected = false,
            onSelected = {},
            onDeselected = {},
            onOpenSave = {}
        )
    }
}