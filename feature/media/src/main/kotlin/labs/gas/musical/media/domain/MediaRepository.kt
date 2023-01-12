package labs.gas.musical.media.domain

import labs.gas.musical.network.DomainError
import labs.gas.musical.network.Either
import labs.gas.musical.media.domain.model.MediaDomainModel

interface MediaRepository {
    suspend fun search(query: String): Either<DomainError, List<MediaDomainModel>?>
}
