package com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LocalitiesScreen(localitiesViewModel: LocalitiesViewModel) {

    localitiesViewModel.getListLocalities()
    val localitiesList by localitiesViewModel.localitiesList.collectAsState()

    LazyColumn {

        items(localitiesList) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                    ),
            ) {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = it.NombreCompleto, style = MaterialTheme.typography.titleMedium)
                    Text(text = it.AbreviacionCiudad, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}