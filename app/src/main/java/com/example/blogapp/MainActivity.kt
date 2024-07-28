package com.example.blogapp

import android.os.Bundle
import android.util.Log
import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            KeyBordComposable()
            TextField(value = "", onValueChange = {})
        }
    }
}

@Composable
fun KeyBordComposable() {

    val view = LocalView.current
    DisposableEffect(key1 = Unit) {
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            val insert = ViewCompat.getRootWindowInsets(view)
            val isKeyBordVisible = insert?.isVisible(WindowInsetsCompat.Type.ime())
            Log.d("SN", isKeyBordVisible.toString())
        }

        view.viewTreeObserver.addOnGlobalLayoutListener(listener)
        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        }

    }

}


/*

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

 */
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


