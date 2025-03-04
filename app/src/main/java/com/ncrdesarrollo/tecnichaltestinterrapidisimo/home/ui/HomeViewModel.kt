package com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.domain.IHomeInteractor
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.domain.IHomeRepository
import com.ncrdesarrollo.tecnichaltestinterrapidisimo.home.ui.model.UserData

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val interactor: IHomeInteractor) : ViewModel() {

    private var _versionMessage = MutableStateFlow<String>("")
    var versionMessage: StateFlow<String> = _versionMessage

    private var _userData = MutableStateFlow<UserData>(UserData("","",""))
    var userData: StateFlow<UserData> = _userData

    fun getVersion() {
        viewModelScope.launch {
            try {
                _versionMessage.value = interactor.getVersionMessage()
            } catch (e: Exception) {
                Log.e("error", e.message.toString())
            }
        }
    }

    fun login() {
        viewModelScope.launch {
            try {
                _userData.value = interactor.login()
            } catch (e: Exception) {
                Log.e("error", e.message.toString())
            }
        }
    }
}