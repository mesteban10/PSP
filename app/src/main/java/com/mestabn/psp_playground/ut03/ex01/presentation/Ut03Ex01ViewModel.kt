package com.mestabn.psp_playground.ut03.ex01.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mestabn.psp_playground.ut03.ex01.app.RetrofitApiClient
import com.mestabn.psp_playground.ut03.ex01.domain.UserApiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Ut03Ex01ViewModel() : ViewModel() {

    /**
     * Ejecuto una coroutine con un Scope (alcance) Global
     * No finaliza hasta que no acabe la app
     */
    fun getUsersGlobalScope() {
        viewModelScope.launch(Dispatchers.Main) {
            var i = 0
            while (true) {
                Log.d("@dev", "Hola: $i")
                Thread.sleep(1000)
                i += 1
            }
            Log.d("@dev", "Ui Thread")
        }
    }

    fun getUserViewModelScope() {
        val apiClient = RetrofitApiClient()
        viewModelScope.launch(Dispatchers.Main) {
            Log.d("@dev", "Llamo a API from viewModelScope")
            var users: List<UserApiModel> = mutableListOf()
            withContext(Dispatchers.IO) {

                users = apiClient.getUsers()
            }
            Log.d("@dev", "ViewModelScope: $users")
        }


        GlobalScope.launch(Dispatchers.Main) {
            Log.d("@dev", "Llamo a API from GlobalScope")
            var users: List<UserApiModel> = mutableListOf()
            withContext(Dispatchers.IO) {
                users = apiClient.getUsers()
            }
            Log.d("@dev", "GlobalScope: $users")
        }

    }


}