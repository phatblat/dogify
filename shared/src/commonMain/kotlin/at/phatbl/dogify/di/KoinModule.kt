package at.phatbl.dogify.di

import at.phatbl.dogify.FetchBreedsUseCase
import at.phatbl.dogify.GetBreedsUseCase
import at.phatbl.dogify.ToggleFavouriteStateUseCase
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

private val usecaseModule = module {
    factory { GetBreedsUseCase() }
    factory { FetchBreedsUseCase() }
    factory { ToggleFavouriteStateUseCase() }
}

private val sharedModules = listOf(usecaseModule)

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(sharedModules)
}

