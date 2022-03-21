package com.dcbrh.projectgraphql

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.ApolloClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RAMViewModel: ViewModel() {

    fun getQuery(apolloClient: ApolloClient) {
        viewModelScope.launch(Dispatchers.IO) {
            query(apolloClient = apolloClient)
        }
    }

    private suspend fun query(apolloClient: ApolloClient) {
        val response = apolloClient.query(GetCharactersQuery()).execute()
        if (response.data != null) {
            response.data?.characters?.results?.let { Log.d("Response", it.toString()) }
        }
    }

}