package at.phatbl.dogify

class FetchBreedsUseCase {
    suspend fun invoke(): List<Breed> = listOf(Breed("Test fetch", ""))
}
