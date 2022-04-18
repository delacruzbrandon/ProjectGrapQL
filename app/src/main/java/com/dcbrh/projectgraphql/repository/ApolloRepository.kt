package com.dcbrh.projectgraphql.repository

import com.apollographql.apollo3.api.ApolloResponse
import com.dcbrh.projectgraphql.GetCharacterQuery
import com.dcbrh.projectgraphql.GetCharactersQuery

interface ApolloRepository {

    suspend fun getAllCharacters(): ApolloResponse<GetCharactersQuery.Data>

    suspend fun getCharacter(id: String): ApolloResponse<GetCharacterQuery.Data>
}