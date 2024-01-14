package at.phatbl.dogify

class GetBreedsUseCase {
    suspend fun invoke(): List<Breed> = listOf(Breed("Test get", ""))
}
