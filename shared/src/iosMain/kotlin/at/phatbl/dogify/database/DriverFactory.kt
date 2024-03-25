package at.phatbl.dogify.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import at.phatbl.dogify.db.DogifyDatabase
import org.koin.core.scope.Scope

internal actual fun Scope.createDriver(databaseName: String): SqlDriver =
    NativeSqliteDriver(DogifyDatabase.Schema, databaseName)
