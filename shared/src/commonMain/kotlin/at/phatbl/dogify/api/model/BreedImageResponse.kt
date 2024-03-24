package at.phatbl.dogify.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class BreedImageResponse(
    @SerialName("message")
    val breedImageUrl: String,
)
