package labs.gas.musical.media.data

import labs.gas.musical.network.DomainError
import labs.gas.musical.network.Either
import labs.gas.musical.media.data.remote.MediaRemoteDataSource
import labs.gas.musical.media.domain.MediaRepository
import labs.gas.musical.media.domain.mappers.toDomainError
import labs.gas.musical.media.domain.mappers.toDomainModel
import labs.gas.musical.media.domain.model.MediaDomainModel

class MediaDataRepository(
    private val remoteDataSource: MediaRemoteDataSource
) : MediaRepository {

    override suspend fun search(query: String): Either<DomainError, List<MediaDomainModel>?> {
        return remoteDataSource
            .search(query)
            .bimap(
                { it.toDomainError() },
                { remoteModel -> remoteModel?.map { it.toDomainModel() } }
            )
    }
}
