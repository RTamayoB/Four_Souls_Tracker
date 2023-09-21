package com.rafaeltamayo.foursoulstracker.android.di

import android.app.Application
import com.rafaeltamayo.foursoulstracker.database.FourSoulsTrackerDatabase
import com.rafaeltamayo.foursoulstracker.tracker.data.TrackerRepository
import com.rafaeltamayo.foursoulstracker.tracker.data.local.DatabaseDriverFactory
import com.rafaeltamayo.foursoulstracker.tracker.data.local.SqlDelightTrackerDataSource
import com.rafaeltamayo.foursoulstracker.tracker.domain.TrackerDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabaseDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideTrackerDataSource(driver: SqlDriver): TrackerDataSource {
        return SqlDelightTrackerDataSource(FourSoulsTrackerDatabase(driver))
    }

    @Provides
    @Singleton
    fun provideTrackerRepository(
        dataSource: TrackerDataSource
    ): TrackerRepository {
        return TrackerRepository(dataSource)
    }
}