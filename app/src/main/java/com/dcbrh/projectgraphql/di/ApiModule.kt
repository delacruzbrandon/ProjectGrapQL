package com.dcbrh.projectgraphql.di

import com.apollographql.apollo3.ApolloClient
import com.dcbrh.projectgraphql.client.RickAndMortyApi
import com.dcbrh.projectgraphql.util.Constants.SERVER_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideWebService() = RickAndMortyApi()
}