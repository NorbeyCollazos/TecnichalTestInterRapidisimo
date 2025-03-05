package com.ncrdesarrollo.tecnichaltestinterrapidisimo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.ui.HomeViewModel
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.ui.LocalitiesViewModel
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.ui.SchemaScreen
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.ui.SchemaViewModel
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.ui.theme.TecnichalTestInterRapidisimoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()
    private val localitiesViewModel by viewModels<LocalitiesViewModel>()
    private val schemaViewModel by viewModels<SchemaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TecnichalTestInterRapidisimoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //HomeScreen(innerPadding, homeViewModel)
                    //LocalitiesScreen(innerPadding, localitiesViewModel)
                    SchemaScreen(schemaViewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TecnichalTestInterRapidisimoTheme {
        Greeting("Android")
    }
}