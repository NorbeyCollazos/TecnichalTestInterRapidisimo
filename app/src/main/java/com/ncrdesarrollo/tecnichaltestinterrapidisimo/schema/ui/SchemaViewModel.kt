package com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.schema.domain.ISchemaInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchemaViewModel @Inject constructor(private val interactor: ISchemaInteractor) : ViewModel() {

    fun getSchema() {
        viewModelScope.launch {
            interactor.getSchema()
        }
    }
}