package com.rafaeltamayo.foursoulstracker.core.data.database

import com.rafaeltamayo.foursoulstracker.database.FourSoulsTrackerDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(FourSoulsTrackerDatabase.Schema, "foursoulstracker.db")
    }
}