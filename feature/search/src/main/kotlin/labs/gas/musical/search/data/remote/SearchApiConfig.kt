package labs.gas.musical.search.data.remote

import labs.gas.musical.network.ApiConfig

data class SearchApiConfig(
    override val baseUrl: String,
    override val timeout: Long,
    override val isProd: Boolean
) : ApiConfig
