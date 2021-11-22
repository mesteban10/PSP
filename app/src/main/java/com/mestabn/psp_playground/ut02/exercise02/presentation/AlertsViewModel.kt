package com.mestabn.psp_playground.ut02.exercise02.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.mestabn.psp_playground.ut02.exercise02.app.RetrofitApiAlerts
import com.mestabn.psp_playground.ut02.exercise02.data.AlertsDataRepository
import com.mestabn.psp_playground.ut02.exercise02.data.remote.AlertRemoteSource
import com.mestabn.psp_playground.ut02.exercise02.domain.AlertModels
import com.mestabn.psp_playground.ut02.exercise02.domain.GetAlertUseCase
import com.mestabn.psp_playground.ut02.exercise02.domain.GetAlertsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AlertsViewModel(
    private val getAlertsUseCase: GetAlertsUseCase,
    private val getAlertUseCase: GetAlertUseCase
) : ViewModel() {


    fun getAlerts() {
        var alerts: List<AlertModels> = mutableListOf()
        GlobalScope.launch(Dispatchers.Main) {
            Log.d("@dev", "Listado de alertas:")
            alerts = getAlertsUseCase.execute()
            Log.d("@dev", "$alerts")

            GlobalScope.launch {
                Log.d("@dev", "Description de una alerta por id:")
                val alert = getAlertUseCase.execute("1671086")!!
                Log.d("@dev", "$alert")
            }

        }


    }


}




