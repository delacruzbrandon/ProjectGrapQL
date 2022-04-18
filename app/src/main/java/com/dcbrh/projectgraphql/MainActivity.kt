package com.dcbrh.projectgraphql

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.apollographql.apollo3.ApolloClient
import com.dcbrh.projectgraphql.navigation.SetNavigation
import com.dcbrh.projectgraphql.ui.theme.ProjectGraphQLTheme
import com.dcbrh.projectgraphql.util.Constants.SERVER_URL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var apolloClient: ApolloClient

    private lateinit var navHostController: NavHostController

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

                SetNavigation(
                    navController = navHostController,
                    sharedViewModel = sharedViewModel
                )
            }
        }



    }
}