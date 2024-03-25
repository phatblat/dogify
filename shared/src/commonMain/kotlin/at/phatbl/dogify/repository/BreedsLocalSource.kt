package at.phatbl.dogify.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import at.phatbl.dogify.Breed
import at.phatbl.dogify.db.DogifyDatabase
import at.phatbl.dogify.util.DispatcherProvider
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class BreedsLocalSource(
    database: DogifyDatabase,
    private val dispatcherProvider: DispatcherProvider
) {
    private val dao = database.breedsQueries

    suspend fun getBreeds() = withContext(dispatcherProvider.io) {
        dao.selectAll().asFlow().mapToList(coroutineContext)
            .map { breeds ->
                breeds.map {
                    Breed(it.name, it.imageUrl, it.isFavourite ?: false)
                }
            }
    }

    suspend fun selectAll() = withContext(dispatcherProvider.io) {
        dao.selectAll { name, imageUrl, isFavourite ->
            Breed(name, imageUrl, isFavourite ?: false)
        }
            .executeAsList()
    }

    suspend fun insert(breed: Breed) = withContext(dispatcherProvider.io) {
        dao.insert(breed.name, breed.imageUrl, breed.isFavourite)
    }

    suspend fun update(breed: Breed) = withContext(dispatcherProvider.io) {
        dao.update(breed.imageUrl, breed.isFavourite, breed.name)
    }

    suspend fun clear() = withContext(dispatcherProvider.io) {
        dao.clear()
    }
}
