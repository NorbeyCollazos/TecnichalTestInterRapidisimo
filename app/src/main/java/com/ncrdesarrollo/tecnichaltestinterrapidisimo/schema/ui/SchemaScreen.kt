package com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.ui

import androidx.compose.runtime.Composable

@Composable
fun SchemaScreen(schemaViewModel: SchemaViewModel) {

    schemaViewModel.getSchema()
}