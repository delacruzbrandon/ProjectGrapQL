package com.dcbrh.projectgraphql

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.ApolloClient
import com.dcbrh.projectgraphql.models.CharacterModel
import com.dcbrh.projectgraphql.util.RequestState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SharedViewModel: ViewModel() {

    private val _characterList = MutableStateFlow<RequestState<List<CharacterModel>>>(RequestState.Idle)
    val characterList: StateFlow<RequestState<List<CharacterModel>>> = _characterList

    fun getQuery(apolloClient: ApolloClient) {
        viewModelScope.launch(Dispatchers.IO) {
            query(apolloClient = apolloClient)
        }
    }

    private suspend fun query(apolloClient: ApolloClient) {
        val response = apolloClient.query(GetRepositoriesQuery()).execute()
        response.data?.characters?.results?.let { Log.d("Response", it.toString()) }
    }
}