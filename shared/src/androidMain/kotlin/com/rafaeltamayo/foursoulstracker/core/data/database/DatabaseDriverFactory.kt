package com.rafaeltamayo.foursoulstracker.core.data.database

import android.content.Context
import com.rafaeltamayo.foursoulstracker.database.FourSoulsTrackerDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(FourSoulsTrackerDatabase.Schema, context, "foursoulstracker.db")
    }
}