package com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.domain.ILocalitiesInteractor
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.localities.ui.model.LocalitieData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocalitiesViewModel @Inject constructor(private val interactor: ILocalitiesInteractor) : ViewModel(){

    private var _localitiesList = MutableStateFlow<List<LocalitieData>>(listOf())
    var localitiesList: StateFlow<List<LocalitieData>> = _localitiesList

    fun getListLocalities() {
        viewModelScope.launch {
            _localitiesList.value = interactor.getListLocalities()
        }
    }
}