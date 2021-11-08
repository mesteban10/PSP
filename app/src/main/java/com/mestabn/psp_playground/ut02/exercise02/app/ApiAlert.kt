package com.mestabn.psp_playground.ut02.exercise02.app

import com.mestabn.psp_playground.ut02.exercise02.data.remote.AlertApiModel

interface ApiAlert {
    fun getAlerts(): List<AlertApiModel>
}