package labs.gas.musical.search.data.remote.itunes

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import labs.gas.musical.search.data.model.MediaRemoteModel
import labs.gas.musical.search.data.remote.RemoteDataSource
import labs.gas.musical.network.ApiClient
import labs.gas.musical.network.Either
import labs.gas.musical.network.RemoteError
import labs.gas.musical.network.apiCall

class ItunesRemoteDataSource constructor(
    private val itunesApi: ApiClient<ItunesApi>,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : RemoteDataSource {
    override suspend fun search(query: String): Either<RemoteError, List<MediaRemoteModel>?> {
        return apiCall(dispatcher) {
            itunesApi.endpoints.search(query)
        }.coMapSuccess { it.body()?.songs }
    }
}
