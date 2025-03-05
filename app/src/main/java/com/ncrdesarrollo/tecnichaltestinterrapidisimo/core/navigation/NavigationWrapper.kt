package com.ncrdesarrollo.tecnichaltestinterrapidisimo.core.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.ui.HomeScreen
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.ui.HomeViewModel
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.ui.LocalitiesScreen
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.ui.LocalitiesViewModel
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.ui.SchemaScreen
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.ui.SchemaViewModel

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(
                homeViewModel = viewModel,
                navigateToSchema = { navController.navigate(Schema) },
                navigateToLocalities = { navController.navigate(Localities) })
        }

        composable<Schema> {
            val viewModel = hiltViewModel<SchemaViewModel>()
            SchemaScreen(schemaViewModel = viewModel)
        }

        composable<Localities> {
            val viewModel = hiltViewModel<LocalitiesViewModel>()
            LocalitiesScreen(localitiesViewModel = viewModel)
        }
    }
}