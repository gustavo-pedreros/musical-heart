package labs.gas.musical.search.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import labs.gas.musical.search.data.SearchDataRepository
import labs.gas.musical.search.data.remote.RemoteDataSource
import labs.gas.musical.search.domain.SearchRepository
import labs.gas.musical.search.domain.usecases.SearchMediaUseCase

@Module
@InstallIn(SingletonComponent::class)
class SearchDomainModule {
    @Provides
    fun provideSearchRepository(searchRemoteDataSource: RemoteDataSource): SearchRepository {
        return SearchDataRepository(searchRemoteDataSource)
    }

    @Provides
    fun provideSearchMediaUseCase(
        searchRepository: SearchRepository,
    ): SearchMediaUseCase = SearchMediaUseCase(searchRepository::search)
}
