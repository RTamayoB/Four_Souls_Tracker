package com.rafaeltamayo.foursoulstracker.android.tracker

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaeltamayo.foursoulstracker.android.R

@Composable
fun TrackerScreen() {
    Scaffold { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Image(
                painter = painterResource(id = R.drawable.character_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        shape = CircleShape,
                        containerColor = Color.Red,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Refresh, contentDescription = "Reset character")
                    }
                    Spacer(modifier = Modifier.weight(1F))
                }
                Image(
                    painter = painterResource(id = R.drawable.isaac_dead),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.size(200.dp)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.revive_icon),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                            tint = Color.Unspecified
                        )
                    }
                    Spacer(modifier = Modifier.width(18.dp))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.kill_icon),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp),
                            tint = Color.Unspecified
                        )
                    }
                }
                StatController(
                    icon = R.drawable.ic_action_heart,
                    text = "HP",
                    value = 2,
                    onStatUp = {},
                    onStatDown = {}
                )
                StatController(
                    icon = R.drawable.ic_action_sword,
                    text = "DMG",
                    value = 1,
                    onStatUp = {},
                    onStatDown = {}
                )
                StatController(
                    icon = R.drawable.ic_action_dice,
                    text = "DICE",
                    value = 1,
                    onStatUp = {},
                    onStatDown = {}
                )
                StatController(
                    icon = R.drawable.ic_action_soul,
                    text = "SOULS",
                    value = 0,
                    onStatUp = {},
                    onStatDown = {}
                )
                Text(
                    text = "Counters",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Yellow)
                )
                LazyColumn {

                }
            }
        }
    }
}

@Composable
fun StatController(
    @DrawableRes icon:  Int,
    text: String,
    value: Int,
    onStatUp: () -> Unit,
    onStatDown: () -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 18.dp)
            .border(1.dp, Color.Black),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color.Unspecified,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.displayMedium
        )
        Spacer(modifier = Modifier.weight(1F))
        IconButton(onClick = onStatUp) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
        }
        Text(
            text = "$value",
            style = MaterialTheme.typography.displayMedium
        )
        IconButton(onClick = onStatDown) {
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}

@Composable
@Preview
fun TrackerScreenPreview() {
    TrackerScreen()
}

@Composable
@Preview
fun StatControllerPreview() {
    var statValue by remember { mutableIntStateOf(2) }
    StatController(
        R.drawable.ic_action_heart,
        "HP",
        statValue,
        onStatUp = {
            statValue = statValue.plus(1)
        },
        onStatDown = {
            statValue = statValue.minus(1)
        }
    )
}