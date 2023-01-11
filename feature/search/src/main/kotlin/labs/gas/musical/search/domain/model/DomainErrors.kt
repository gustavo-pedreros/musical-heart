package labs.gas.musical.search.domain.model

import labs.gas.musical.network.DomainError

data class SearchDomainError(
    override val message: String
) : DomainError
