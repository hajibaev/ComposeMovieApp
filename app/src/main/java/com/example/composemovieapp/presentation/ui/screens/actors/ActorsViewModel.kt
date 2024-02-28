package com.example.composemovieapp.presentation.ui.screens.actors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.composemovieapp.domain.base.Mapper
import com.example.composemovieapp.domain.model.people.PeopleDomain
import com.example.composemovieapp.domain.use_cases.person.PeoplePagingDataManager
import com.example.composemovieapp.presentation.model.people.PeopleUiModel
import com.example.composemovieapp.presentation.ui.screens.actors.model.ActorsEvent
import com.example.composemovieapp.presentation.ui.screens.actors.model.ActorsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ActorsViewModel @Inject constructor(
    peoplePagingDataManager: PeoplePagingDataManager,
    private val peopleMapper: Mapper<PeopleDomain, PeopleUiModel>
) : ViewModel() {


    private val _uiState = MutableStateFlow<ActorsUiState>(ActorsUiState.Loading)
    val uiState = _uiState.asStateFlow()

    val peoples = peoplePagingDataManager.fetchAllPeoplesPagingData()
        .map { it.map { peopleDomain -> peopleMapper.map(peopleDomain) } }
        .cachedIn(viewModelScope)

    fun onEvent(event: ActorsEvent) {
        when (event) {
            is ActorsEvent.OnFetchAllPeoples -> Unit
        }
    }

}