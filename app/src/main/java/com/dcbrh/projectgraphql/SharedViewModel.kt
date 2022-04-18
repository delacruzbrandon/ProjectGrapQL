package com.dcbrh.projectgraphql

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.ApolloClient
import com.dcbrh.projectgraphql.models.CharacterModel
import com.dcbrh.projectgraphql.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val apolloClient: ApolloClient
): ViewModel() {

    private val _characterList = MutableStateFlow<RequestState<List<CharacterModel>>>(RequestState.Idle)
    val characterList: StateFlow<RequestState<List<CharacterModel>>> = _characterList

    fun getQuery() {
        viewModelScope.launch(Dispatchers.IO) {
        }
    }

    private suspend fun getAllCharacters() {
//        val response = apolloClient.query(GetRepositoriesQuery()).execute()
//        response.data?.characters?.results?.let { Log.d("Response", it.toString()) }
    }
}