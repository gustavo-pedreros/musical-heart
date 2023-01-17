package labs.gas.musical.media.domain.usecases

import labs.gas.musical.network.DomainError
import labs.gas.musical.network.Either
import labs.gas.musical.media.domain.model.MediaDomainModel

fun interface SearchUseCase : suspend ((String)) -> Either<DomainError, List<MediaDomainModel>?>
