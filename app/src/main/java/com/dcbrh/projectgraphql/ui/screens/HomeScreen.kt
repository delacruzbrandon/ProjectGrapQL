package com.dcbrh.projectgraphql.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.dcbrh.projectgraphql.SharedViewModel

@Composable
fun HomeScreen(
    navigateToDetailsScreen: (String) -> Unit,
    sharedViewModel: SharedViewModel
) {
    
    LaunchedEffect(key1 = true) {
        sharedViewModel.characterList
    }
    
    Scaffold(
        content = {
            HomeContent()
        }
    //TODO
    )
}