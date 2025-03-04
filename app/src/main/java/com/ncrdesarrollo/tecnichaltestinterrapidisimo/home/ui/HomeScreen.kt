package com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun HomeScreen(innerPadding: PaddingValues, homeViewModel: HomeViewModel) {

    val context = LocalContext.current
    homeViewModel.getVersion()
    homeViewModel.login()

    Column(
        Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val versionMessage: String by homeViewModel.versionMessage.collectAsState(initial = "")
        Toast.makeText(context, versionMessage, Toast.LENGTH_SHORT).show()

        val userInfo by homeViewModel.userData.collectAsState()

        Text("Usuario: ${userInfo.Usuario}")
        Text("Identificación: ${userInfo.Identificacion}")
        Text("Nombre: ${userInfo.Nombre}")

        Button(onClick = {}) {
            Text("Tablas")
        }

        Button(onClick = {}) {
            Text("Localidades")
        }


    }
}