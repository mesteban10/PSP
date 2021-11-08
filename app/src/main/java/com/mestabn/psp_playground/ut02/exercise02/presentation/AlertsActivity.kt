package com.mestabn.psp_playground.ut02.exercise02.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mestabn.psp_playground.R
import com.mestabn.psp_playground.ut02.exercise02.app.MockApiAlerts
import com.mestabn.psp_playground.ut02.exercise02.app.RetrofitApiAlerts
import com.mestabn.psp_playground.ut02.exercise02.data.AlertsDataRepository
import com.mestabn.psp_playground.ut02.exercise02.data.remote.AlertRemoteSource
import com.mestabn.psp_playground.ut02.exercise02.domain.AlertsRepository

class AlertsActivity : AppCompatActivity() {

    private val TAG = AlertsActivity::class.java.simpleName
    private val repository: AlertsRepository =
        AlertsDataRepository(AlertRemoteSource(RetrofitApiAlerts()))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alerts)
        setupView()
        render()
    }

    private fun setupView() {
        supportActionBar?.title = getString(R.string.title_text_ut02)
    }

    private fun render() {
        Thread {
            val model = repository.fetchAll()
            Log.d("@dev", model.toString())
        }.start()

        Thread {
            val model = repository.fetch(1671086)
            Log.d("@dev", model.toString())
        }.start()

    }
}