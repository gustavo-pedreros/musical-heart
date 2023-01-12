package labs.gas.musical.search.domain.usecases

import labs.gas.musical.network.DomainError
import labs.gas.musical.network.Either
import labs.gas.musical.search.domain.model.MediaDomainModel

fun interface SearchUseCase : suspend ((String)) -> Either<DomainError, List<MediaDomainModel>?>
