package com.dcbrh.projectgraphql.navigation.destinations

import androidx.navigation.NavArgument
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.dcbrh.projectgraphql.util.Constants.DETAILS_ARGUMENT_KEY
import com.dcbrh.projectgraphql.util.Constants.DETAILS_SCREEN

fun NavGraphBuilder.detailsComposable() {
    composable(
        route = DETAILS_SCREEN,
        arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        // TODO
    }
}