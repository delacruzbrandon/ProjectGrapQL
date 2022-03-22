package com.dcbrh.projectgraphql

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.apollographql.apollo3.ApolloClient
import com.dcbrh.projectgraphql.ui.screens.HomeContent
import com.dcbrh.projectgraphql.ui.theme.ProjectGraphQLTheme
import com.dcbrh.projectgraphql.util.Constants.SERVER_URL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    private lateinit var apolloClient: ApolloClient

    private val sharedViewModel: SharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectGraphQLTheme {
                apolloClient = ApolloClient
                    .Builder()
                    .serverUrl(SERVER_URL)
                    .build()

                navHostController = rememberNavController()
            }
        }



        SharedViewModel().getQuery(apolloClient)
    }
}