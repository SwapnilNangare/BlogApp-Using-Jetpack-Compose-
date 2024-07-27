package com.example.blogapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.blogapp.ui.theme.BlogAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListComposable()

        }
    }
}


@Composable
fun ListComposable() {
    val categoryState = remember { mutableStateOf(emptyList<String>()) }

    LaunchedEffect(key1 = Unit) {
        categoryState.value = fetchCategory()

    }

    LazyColumn {
        items(categoryState.value) { item ->
            Text(text = item)

        }
    }

}

fun fetchCategory(): List<String> {

    return listOf("One", "Two", "Three")

}

/*
@Composable
fun App() {

    var theme = remember { mutableStateOf(false) }

    BlogAppTheme(theme.value) {

        Column(Modifier.background(MaterialTheme.colorScheme.background)) {
            Text(
                text = "Swapyy", style = MaterialTheme.typography.headlineLarge
            )

            Button(onClick = {
                theme.value = !theme.value
            }) {
                Text(text = "Change Theme")

            }

        }
    }

}
 */


