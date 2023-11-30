package com.toko.anugrah.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toko.anugrah.data.AnugrahApiRepository
import com.toko.anugrah.data.NetworkAnugrahApiRepository
import com.toko.anugrah.network.User
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

/**
 * ViewModel to retrieve all items in the Room database.
 */
class HomeViewModel (anugrahApiRepository: AnugrahApiRepository): ViewModel() {

    val homeUiState: StateFlow<HomeUiState> =
            anugrahApiRepository.getAllUser().map { HomeUiState(it) }
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                    initialValue = HomeUiState()
                )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

//  Tentukan apa yang ingin kau tampilkan di sini
data class HomeUiState(val itemList: List<User> = listOf())

//sealed interface HomeUiState {
//    data class Success(val photos: List<User>) : HomeUiState
//    object Error : HomeUiState
//    object Loading : HomeUiState
//}