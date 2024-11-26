package com.openclassrooms.p8vitesse.presentation.ui.homescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.p8vitesse.domain.model.Candidate
import com.openclassrooms.p8vitesse.domain.usecase.GetAllCandidatesUseCase
import com.openclassrooms.p8vitesse.domain.usecase.GetFavoriteCandidatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllCandidatesUseCase: GetAllCandidatesUseCase,
    private val getFavoriteCandidatesUseCase: GetFavoriteCandidatesUseCase
): ViewModel(){

    private val _candidates = MutableStateFlow<List<Candidate>>(emptyList())
    val candidates: StateFlow<List<Candidate>> = _candidates

    init {
        loadAllCandidates()
    }

    private fun loadAllCandidates() {
        viewModelScope.launch {
            getAllCandidatesUseCase.execute().collect { list ->
                _candidates.value = list
            }
        }
    }
}