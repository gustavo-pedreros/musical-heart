package labs.gas.musical.search.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import labs.gas.musical.network.ApiClient
import labs.gas.musical.network.RetrofitClient
import labs.gas.musical.search.data.remote.RemoteDataSource
import labs.gas.musical.search.data.remote.SearchApiConfig
import labs.gas.musical.search.data.remote.itunes.ItunesApi
import labs.gas.musical.search.data.remote.itunes.ItunesRemoteDataSource

@Module
@InstallIn(SingletonComponent::class)
class SearchDataModule {
    @Provides
    fun provideSearchRemoteDataSource(apiClient: ApiClient<ItunesApi>): RemoteDataSource {
        return ItunesRemoteDataSource(apiClient, Dispatchers.IO)
    }

    @Provides
    internal fun provideRetrofitApiClient(@ApplicationContext context: Context): ApiClient<ItunesApi> = RetrofitClient(
        apiConfig = SearchApiConfig(
            baseUrl = "https://itunes.apple.com",
            timeout = 60,
            isProd = false
        ),
        clazz = ItunesApi::class.java
    )

}
