package labs.gas.musical.media.data.remote.itunes

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import labs.gas.musical.media.data.model.MediaRemoteModel
import labs.gas.musical.media.data.remote.MediaRemoteDataSource
import labs.gas.musical.network.ApiClient
import labs.gas.musical.network.Either
import labs.gas.musical.network.RemoteError
import labs.gas.musical.network.apiCall

class ItunesDataSource constructor(
    private val itunesApi: ApiClient<ItunesApi>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MediaRemoteDataSource {
    override suspend fun search(query: String): Either<RemoteError, List<MediaRemoteModel>?> {
        return apiCall(dispatcher) {
            itunesApi.endpoints.search(query)
        }.coMapSuccess { it.body()?.songs }
    }
}
