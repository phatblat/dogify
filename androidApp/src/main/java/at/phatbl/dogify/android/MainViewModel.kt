package at.phatbl.dogify.android

import androidx.lifecycle.ViewModel
import at.phatbl.dogify.FetchBreedsUseCase
import at.phatbl.dogify.GetBreedsUseCase
import at.phatbl.dogify.ToggleFavouriteStateUseCase
import at.phatbl.dogify.repository.BreedsRepository

class MainViewModel(
    breedsRepository: BreedsRepository,
    private val getBreeds: GetBreedsUseCase,
    private val fetchBreeds: FetchBreedsUseCase,
    private val onToggleFavouriteState: ToggleFavouriteStateUseCase
) : ViewModel()
