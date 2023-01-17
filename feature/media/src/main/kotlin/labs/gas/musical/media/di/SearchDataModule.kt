package labs.gas.musical.media.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import labs.gas.musical.network.ApiClient
import labs.gas.musical.network.RetrofitClient
import labs.gas.musical.media.data.remote.MediaRemoteDataSource
import labs.gas.musical.media.data.remote.MediaApiConfig
import labs.gas.musical.media.data.remote.itunes.ItunesApi
import labs.gas.musical.media.data.remote.itunes.ItunesDataSource

@Module
@InstallIn(SingletonComponent::class)
class SearchDataModule {
    @Provides
    fun provideSearchRemoteDataSource(apiClient: ApiClient<ItunesApi>): MediaRemoteDataSource {
        return ItunesDataSource(apiClient, Dispatchers.IO)
    }

    @Provides
    internal fun provideRetrofitApiClient(@ApplicationContext context: Context): ApiClient<ItunesApi> = RetrofitClient(
        apiConfig = MediaApiConfig(
            baseUrl = "https://itunes.apple.com",
            timeout = 60,
            isProd = false
        ),
        clazz = ItunesApi::class.java
    )

}
