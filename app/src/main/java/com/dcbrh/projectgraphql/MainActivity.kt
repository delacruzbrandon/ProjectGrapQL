package com.dcbrh.projectgraphql

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.apollographql.apollo3.ApolloClient
import com.dcbrh.projectgraphql.ui.theme.ProjectGraphQLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectGraphQLTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }

        val apolloClient = ApolloClient.Builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .build()

        RAMViewModel().getQuery(apolloClient)
    }
}

@Composable
fun Profile(name: String) {
    Image(painter = rememberImagePainter(data = ""), contentDescription = "")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProjectGraphQLTheme {
    }
}