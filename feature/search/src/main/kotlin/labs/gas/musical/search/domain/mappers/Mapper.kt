package labs.gas.musical.search.domain.mappers

import labs.gas.musical.network.RemoteError
import labs.gas.musical.search.data.model.MediaRemoteModel
import labs.gas.musical.search.domain.model.MediaDomainModel
import labs.gas.musical.search.domain.model.SearchDomainError

fun RemoteError.toDomainError() = SearchDomainError(message)

fun MediaRemoteModel.toDomainModel() = MediaDomainModel(songId, photo, songName, albumName, artistName, trackTimeMillis)
