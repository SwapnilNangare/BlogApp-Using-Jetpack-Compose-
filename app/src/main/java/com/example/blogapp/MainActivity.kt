package com.example.blogapp

import android.os.Bundle
import android.util.Log
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
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.blogapp.ui.theme.BlogAppTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            App()
        }
    }
}


@Composable
fun App() {

    val counter = remember { mutableStateOf(0) }
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        counter.value = 10

    }
    Counter(counter.value)

}

@Composable
fun Counter(value: Int) {

    val state = rememberUpdatedState(newValue = value)
    LaunchedEffect(key1 = Unit) {
        delay(5000)
        Log.d("Swapnil", state.value.toString())

    }
    Text(text = value.toString())
}
/*
@Composable
fun Counter() {


    val count = remember { mutableStateOf(0) }
    val key = count.value % 3 == 0
    LaunchedEffect(key1 = key) {
        Log.d("Counter", "Current count: ${count.value}")

    }
    Button(onClick = { count.value++ }) {
        Text(text = "Increment count")

    }
}

/*
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


 */
fun fetchCategory(): List<String> {

    return listOf("One", "Two", "Three")

}


 */
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


