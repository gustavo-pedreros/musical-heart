package labs.gas.musical.search.data.remote

import labs.gas.musical.network.ApiConfig
import labs.gas.musical.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

data class SearchApiConfig(
    override val baseUrl: String,
    override val timeout: Long,
    override val isProd: Boolean,
) : ApiConfig {

    override fun interceptors(): List<Interceptor> = buildList {
        add(HttpLoggingInterceptor().setLevel(loggerLevel))
    }

    private val loggerLevel = when (BuildConfig.DEBUG) {
        true -> HttpLoggingInterceptor.Level.BODY
        false -> HttpLoggingInterceptor.Level.NONE
    }
}
