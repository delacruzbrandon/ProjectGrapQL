package com.dcbrh.projectgraphql.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.dcbrh.projectgraphql.SharedViewModel
import com.dcbrh.projectgraphql.navigation.destinations.homeComposable
import com.dcbrh.projectgraphql.util.Constants.HOME_SCREEN

@Composable
fun SetNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val appScreen = remember(navController) {
        AppScreens(navController = navController)
    }
    // TODO
    NavHost(
        navController = navController,
        startDestination = HOME_SCREEN
    ) {
        homeComposable(
            navigateToDetailsScreen = appScreen.detailsScreen,
            sharedViewModel = sharedViewModel
        )
    }
}