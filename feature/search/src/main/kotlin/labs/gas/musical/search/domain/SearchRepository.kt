package labs.gas.musical.search.domain

import labs.gas.musical.network.DomainError
import labs.gas.musical.network.Either
import labs.gas.musical.search.domain.model.MediaDomainModel

interface SearchRepository {
    suspend fun search(query: String): Either<DomainError, List<MediaDomainModel>?>
}
