package com.dcbrh.projectgraphql.client

import android.os.Looper
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import com.dcbrh.projectgraphql.util.Constants.SERVER_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RickAndMortyApi {

    @Singleton
    @Provides
    fun getApolloClient(): ApolloClient {
        check(Looper.myLooper() == Looper.getMainLooper()) {
            "Only the main thread can get the apolloClient instance"
        }

        val okHttpClient = OkHttpClient.Builder().build()

        return ApolloClient.Builder()
            .serverUrl(SERVER_URL)
            .okHttpClient(okHttpClient = okHttpClient)
            .build()
    }
}