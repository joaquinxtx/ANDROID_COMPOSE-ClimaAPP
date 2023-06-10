package com.joaquindev.climaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joaquindev.climaapp.presentation.screens.HomeScreen
import com.joaquindev.climaapp.presentation.screens.HomeScreenViewModel
import com.joaquindev.climaapp.ui.theme.ClimaAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val homeScreenViewModel:HomeScreenViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClimaAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(

                ) {
                    HomeScreen(homeScreenViewModel =homeScreenViewModel )

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ClimaAppTheme {
        Greeting("Android")
    }
}