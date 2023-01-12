package labs.gas.musical.media.domain.model

import labs.gas.musical.network.DomainError

data class SearchDomainError(
    override val message: String
) : DomainError
