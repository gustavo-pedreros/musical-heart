package labs.gas.musical.media.presentation.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import labs.gas.musical.media.domain.usecases.SearchUseCase
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase,
) : ViewModel() {
    fun search(query: String) {
        viewModelScope.launch {
            searchUseCase(query).bimap(
                { Log.d(SearchViewModel::class.simpleName, it.message) },
                {
                    Log.d(SearchViewModel::class.simpleName, "Success")
                }
            )
        }
    }
}
