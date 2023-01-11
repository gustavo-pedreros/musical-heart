package labs.gas.musical.search.domain.model

class MediaDomainModel(
    val id: Int,
    val photo: String,
    val name: String?,
    val album: String?,
    val artist: String,
    val duration: Int,
    var isFavorite: Boolean = false
)
