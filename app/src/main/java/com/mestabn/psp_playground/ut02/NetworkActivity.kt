package com.mestabn.psp_playground.ut02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mestabn.psp_playground.R

class NetworkActivity : AppCompatActivity() {

    //Etiqueta para los Logs.
    private val TAG = NetworkActivity::class.java.canonicalName

    //Se crea el cliente que vamos a usar. Esto debería ser hecho con un Inyector de dependencias.
    private val apiClient: ApiClient = RetrofitApiClient()

    /**
     * Ciclo de vida de la actividad. Primer método que se ejecuta en el ciclo de vida.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)
        //testSyncApi() //No se puede hacer la llamada dentro del hilo ppal a la API, al MockApiClient si
        testAsyncApi() //Llamada dentro de un hilo

    }

    /**
     * Función que ejecuta el cliente en modo síncrono: Crash cuando accedemos a API.
     */
    private fun testSyncApi() {
        val users = apiClient.getUsers()
        if (users.isNotEmpty()) {
            users.forEach {
                Log.i(TAG, "$it")
            }
        } else {
            Log.i(TAG, "User list is empty")
        }
    }

    /**
     * Función que ejecuta el cliente en modo asíncrono, en un hilo diferente a la UI.
     */
    private fun testAsyncApi() {
        val threadNetwotk = Thread(Runnable {
            val users = apiClient.getUsers()
            if (users.isNotEmpty()) {
                users.forEach {
                    Log.i(TAG, "$it")
                }
            } else {
                Log.i(TAG, "User list is empty")
            }
        })
        threadNetwotk.start()
    }

}
