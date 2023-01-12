package labs.gas.musical.media.data.remote

import labs.gas.musical.media.data.model.MediaRemoteModel
import labs.gas.musical.network.Either
import labs.gas.musical.network.RemoteError

interface MediaRemoteDataSource {
    suspend fun search(query: String): Either<RemoteError, List<MediaRemoteModel>?>
}
