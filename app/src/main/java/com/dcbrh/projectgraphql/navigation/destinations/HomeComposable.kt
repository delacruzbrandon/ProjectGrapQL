package com.dcbrh.projectgraphql.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dcbrh.projectgraphql.SharedViewModel
import com.dcbrh.projectgraphql.ui.screens.HomeScreen
import com.dcbrh.projectgraphql.util.Constants.HOME_SCREEN

// TODO
fun NavGraphBuilder.homeComposable(
    navigateToDetailsScreen: (String) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = HOME_SCREEN
    ) {
        HomeScreen(
            navigateToDetailsScreen = navigateToDetailsScreen,
            sharedViewModel = sharedViewModel
        )
    }
}