package com.rafaeltamayo.foursoulstracker.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rafaeltamayo.foursoulstracker.android.core.ui.theme.MyApplicationTheme
import com.rafaeltamayo.foursoulstracker.android.saves.AndroidSavesViewModel
import com.rafaeltamayo.foursoulstracker.android.saves.SavesScreen
import com.rafaeltamayo.foursoulstracker.android.tracker.TrackerScreen
import com.rafaeltamayo.foursoulstracker.android.tracker.viewmodel.AndroidTrackerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainNavHost()
                }
            }
        }
    }
}

@Composable
fun MainNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "saves"
    ) {
        composable("saves") {
            val viewModel = hiltViewModel<AndroidSavesViewModel>()
            val state by viewModel.state.collectAsState()

            SavesScreen(
                state = state,
                onEvent = {
                    viewModel.onEvent(it)
                }
            )
        }
        composable(
            route = "tracker/{saveId}",
            arguments = listOf(navArgument("saveId") { type = NavType.StringType })
        ) {
            val viewModel = hiltViewModel<AndroidTrackerViewModel>()
            val state by  viewModel.state.collectAsState()

            TrackerScreen(
                state = state,
                onEvent = {
                    viewModel.onEvent(it)
                }
            )
        }
    }
}