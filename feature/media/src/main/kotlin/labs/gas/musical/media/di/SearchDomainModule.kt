package labs.gas.musical.media.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import labs.gas.musical.media.data.MediaDataRepository
import labs.gas.musical.media.data.remote.MediaRemoteDataSource
import labs.gas.musical.media.domain.MediaRepository
import labs.gas.musical.media.domain.usecases.SearchUseCase

@Module
@InstallIn(SingletonComponent::class)
class SearchDomainModule {
    @Provides
    fun provideSearchRepository(searchRemoteDataSource: MediaRemoteDataSource): MediaRepository {
        return MediaDataRepository(searchRemoteDataSource)
    }

    @Provides
    fun provideSearchUseCase(
        searchRepository: MediaRepository,
    ): SearchUseCase = SearchUseCase(searchRepository::search)
}
