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
        //testSyncApiUsers() //No se puede hacer la llamada dentro del hilo ppal a la API, al MockApiClient si
        //testAsyncApiUsers() //Llamada dentro de un hilo
        //testSyncApiPosts()
        //testAsyncApiPosts()
        testAsyncApiUser()

    }

    /**
     * Función que ejecuta el cliente en modo síncrono: Crash cuando accedemos a API.
     */
    private fun testSyncApiUsers() {
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
    private fun testAsyncApiUsers() {
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

    /**
     * Función que ejecuta el post en modo síncrono: Crash cuando accedemos a API.
     */
    private fun testSyncApiPosts() {
        val posts = apiClient.getPosts()
        if (posts.isNotEmpty()) {
            posts.forEach {
                Log.i(TAG, "$it")
            }
        } else {
            Log.i(TAG, "Post list is empty")
        }
    }

    /**
     * Función que ejecuta el post en modo asíncrono, en un hilo diferente a la UI.
     */
    private fun testAsyncApiPosts() {
        val threadNetwotk = Thread(Runnable {
            val posts = apiClient.getPosts()
            if (posts.isNotEmpty()) {
                posts.forEach {
                    Log.i(TAG, "$it")
                }
            } else {
                Log.i(TAG, "Post list is empty")
            }
        })
        threadNetwotk.start()
    }

    private fun testAsyncApiUser() {
        val threadNetwotk = Thread(Runnable {
            val user = apiClient.getUser(4)
            Log.i(TAG, user.toString())

        })
        threadNetwotk.start()
    }



}
