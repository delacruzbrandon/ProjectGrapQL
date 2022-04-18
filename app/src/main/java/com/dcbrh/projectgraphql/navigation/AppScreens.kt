package com.dcbrh.projectgraphql.navigation

import androidx.navigation.NavHostController

class AppScreens(navController: NavHostController) {

    /** Kill composable backstacks and go to [HomeComposable.kt] and  */
    val homeScreen: () -> Unit = {
        navController.popBackStack()
    }

    val detailsScreen: (String) -> Unit = { idDetails ->
        navController.navigate(route = "details/$idDetails}")
    }
}