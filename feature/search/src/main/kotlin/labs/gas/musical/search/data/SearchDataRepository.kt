package labs.gas.musical.search.data

import labs.gas.musical.network.DomainError
import labs.gas.musical.network.Either
import labs.gas.musical.search.data.remote.RemoteDataSource
import labs.gas.musical.search.domain.SearchRepository
import labs.gas.musical.search.domain.mappers.toDomainError
import labs.gas.musical.search.domain.mappers.toDomainModel
import labs.gas.musical.search.domain.model.MediaDomainModel

class SearchDataRepository(
    private val searchRemoteDataSource: RemoteDataSource
) : SearchRepository {

    override suspend fun search(query: String): Either<DomainError, List<MediaDomainModel>?> {
        return searchRemoteDataSource
            .search(query)
            .bimap(
                { it.toDomainError() },
                { remoteModel -> remoteModel?.map { it.toDomainModel() } }
            )
    }
}
