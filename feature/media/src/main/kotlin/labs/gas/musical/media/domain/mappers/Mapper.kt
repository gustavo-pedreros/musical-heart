package labs.gas.musical.media.domain.mappers

import labs.gas.musical.network.RemoteError
import labs.gas.musical.media.data.model.MediaRemoteModel
import labs.gas.musical.media.domain.model.MediaDomainModel
import labs.gas.musical.media.domain.model.SearchDomainError

fun RemoteError.toDomainError() = SearchDomainError(message)

fun MediaRemoteModel.toDomainModel() = MediaDomainModel(songId, photo, songName, albumName, artistName, trackTimeMillis)
