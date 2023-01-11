package labs.gas.musical.search.data.remote

import labs.gas.musical.search.data.model.MediaRemoteModel
import labs.gas.musical.network.Either
import labs.gas.musical.network.RemoteError

interface RemoteDataSource {
    suspend fun search(query: String): Either<RemoteError, List<MediaRemoteModel>?>
}
