package at.phatbl.dogify.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import at.phatbl.dogify.Breed
import at.phatbl.dogify.FetchBreedsUseCase
import at.phatbl.dogify.GetBreedsUseCase
import at.phatbl.dogify.ToggleFavouriteStateUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

suspend fun greet() = "${FetchBreedsUseCase().invoke()}\n" +
    "${GetBreedsUseCase().invoke()}\n" +
    "${ToggleFavouriteStateUseCase().invoke(
        Breed ("toggle favourite state test", "")
    )}\n"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingView()
                }
            }
        }
    }
}

@Composable
fun GreetingView() {
    val myState = remember { mutableStateOf("initial state") }

    LaunchedEffect(Unit) {
        // Call the suspend function using launch
        val result = withContext(Dispatchers.IO) {
            greet()
        }
        myState.value = result
    }

    Text(text = myState.value)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView()
    }
}
