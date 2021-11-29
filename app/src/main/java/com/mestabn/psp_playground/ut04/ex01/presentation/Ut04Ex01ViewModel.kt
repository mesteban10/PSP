package com.mestabn.psp_playground.ut04.ex01.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Ut04Ex01ViewModel : ViewModel() {

    /**
     * Exponemos de forma pública una variable para que la vista o los test los 'observadores'
     * puedan suscribirse al observado.
     */
    val alertViewState: LiveData<AlertViewState>
        get() = _alertViewState

    /**
     * Para poder notificar a los observadores de un cambio de estado (nuevos datos) necesitamos
     * una variable en la que fijarnos para notificar cuando cambie su valor.
     */
    private val _alertViewState: MutableLiveData<AlertViewState> by lazy {
        MutableLiveData<AlertViewState>()
    }

    /**
     * Función que ejecuta la vista y en la que pide datos
     * Lo habitual, es que esta función ejecute un caso de uso.
     */
    fun loadData() = viewModelScope.launch(Dispatchers.Main) {
        delay(1000L)


        //Con hilo MAIN
        //_alertViewState.value = AlertViewState(Random.toString(), Random.toString())

        //Con Hilo Main(más lento) o IO
        _alertViewState.postValue(AlertViewState(toString(), toString()))
    }
}