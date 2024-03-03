package at.phatbl.dogify.di

import at.phatbl.dogify.FetchBreedsUseCase
import at.phatbl.dogify.GetBreedsUseCase
import at.phatbl.dogify.ToggleFavouriteStateUseCase
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

/*
private val apiModule = module { factory { BreedsApi() } }

private val repositoryModule = module {
    single { BreedsRepository(get()) }
    factory { BreedsRemoteSource(get(), get()) }
}

private val usecaseModule = module {
    factory { GetBreedsUseCase() }
    factory { FetchBreedsUseCase() }
    factory { ToggleFavouriteStateUseCase() }
}

private val utilityModule = module {
    factory { getDispatcherProvider() }
}

private val sharedModules = listOf(
    apiModule, repositoryModule, usecaseModule, utilityModule
)

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(sharedModules)
}
*/
