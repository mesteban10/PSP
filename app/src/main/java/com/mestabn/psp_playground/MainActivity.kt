package com.mestabn.psp_playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.mestabn.psp_playground.R

class MainActivity : AppCompatActivity() {

    lateinit var label: TextView
    lateinit var button: Button
    lateinit var spinner : ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()


    }

    /**
     * Metodo pora configurar la vista
     */

    private fun setupView() { //lo ejecuta el hilo de la IU
        label = findViewById(R.id.label)
        button = findViewById(R.id.buttom)
        spinner = findViewById(R.id.spinner)
        button.setOnClickListener {
            //launchARN()
            //withThread()
            //launchInsideThread2()
            //postDeLayed()
            //launchMultipleThreads()
            LaunchProgressBar()

        }

    }

    private fun launchARN() {
        for (i in 1..100) {
            label.text = "Hola $i"
            /**Como si hicieramos un setText*/
            Thread.sleep(2000)
            /**Imprimo numero y paro 2sg*/
        }
    }

    private fun withThread() {
        Thread(Runnable { //cuando le doy a run se crea un proceso del proyecto
            for (i in 1..100) {
                label.text = "Hola $i"
                /**Como si hicieramos un setText*/
                Thread.sleep(2000)
                /**Imprimo numero y paro 2sg*/
            }
        }).start()
        /**Sintaxis para crear un hilo, esto ya no lo ejecuta el hilo de la IU, sino el propio hilo*/
    }

    private fun withThreadAndPost() { //actualiza en el hilo de la UI y despues sigue con el otro hilo
        Thread(Runnable { //cuando le doy a run se crea un proceso del proyecto
            for (i in 1..100) {
                label.post { //obliga al codigo a que sea leido desde el hilo ppal de la UI
                    label.text = "Hola $i"
                }
                Thread.sleep(2000)
                /**Imprimo numero y paro 2sg*/ //fuera de UI
            }
        }).start()

    }

    /**
     * Aqui puedo poner mas widget que en el post(solo 1)
     */
    private fun withRunUIThread() { //actualiza en el hilo de la UI y despues sigue con el otro hilo
        Thread(Runnable { //cuando le doy a run se crea un proceso del proyecto
            for (i in 1..100) {
                runOnUiThread { //metodo que hace lo mismo que el post
                    label.text = "Hola $i"
                }
                Thread.sleep(2000)
                /**Imprimo numero y paro 2sg*/ //fuera de UI
            }
        }).start()

    }

    private fun ThreadFormParam() { //actualiza en el hilo de la UI y despues sigue con el otro hilo
        val thread = Thread(Runnable { //cuando le doy a run se crea un proceso del proyecto
            for (i in 1..100) {
                runOnUiThread { //metodo que hace lo mismo que el post
                    label.text = "Hola $i"
                }
                Thread.sleep(2000)
                /**Imprimo numero y paro 2sg*/ //fuera de UI
            }
        })
        thread.start()
    }

    private fun launchMultipleThreads() {
        val thread1 = Thread(Runnable { //cuando le doy a run se crea un proceso del proyecto
            for (i in 1..100) {
                Log.d("@dev", "Thread-2 $i")

                Thread.sleep(1500)
                /**Imprimo numero y paro 2sg*/
            }
        })

        val thread2 = Thread(Runnable { //cuando le doy a run se crea un proceso del proyecto
            for (i in 1..100) {
                Log.d("@dev", "Thread-2 $i")

                Thread.sleep(1500)
                /**Imprimo numero y paro 2sg*/
            }
        })

        val thread3 = Thread(Runnable { //cuando le doy a run se crea un proceso del proyecto
            for (i in 1..100) {
                Log.d("@dev", "Thread-2 $i")
                Thread.sleep(1500)
                /**Imprimo numero y paro 2sg*/
            }
        })

        thread1.start()
        thread2.start()
        thread3.start()
    }


    //Podemos crear distintos hilos que corran al mismo tiempo

    /*
    HILO DENTRO DE HILO
     */

    private fun launchInsideThread() {
        Thread(Runnable { //cuando le doy a run se crea un proceso del proyecto
            for (i in 1..100) {
                Log.d("@dev", "Thread-1 $i")

                Thread.sleep(1500)

            }
            Thread(Runnable { //cuando le doy a run se crea un proceso del proyecto
                for (i in 1..100) {
                    Log.d("@dev", "Thread-2 $i")
                    Thread.sleep(1500)

                }
            }).start()
        }).start()
    }

    private fun launchInsideThread2() { //el primer hilo(padre) hace que se ejecute el hijo y continúa con sus cosas, son independientes
        Thread(Runnable {
            Thread(Runnable {
                for (i in 1..100) {
                    Log.d("@dev", "thread-2 $i")
                    Thread.sleep(1000)
                }
            }).start()    //Tiene que crear un metodo e inicializarlo
            for (i in 1..100) {
                Log.d("@dev", "thread1 $i")
                Thread.sleep(2000)
            }
        }).start()
    }

    /**
     * Hilo con retraso
     */

    private fun postDeLayed() {
        Handler(Looper.getMainLooper()).postDelayed({
            label.text = "Hola!"
        }, 3000)
    }


    private fun LaunchProgressBar() {
        Thread(Runnable {
            for (i in 1..10) {
                runOnUiThread {
                    label.text = "Hola $i"
                }
                Thread.sleep(1000)
            }
            runOnUiThread{
                spinner.visibility = View.VISIBLE
            }
            Handler(Looper.getMainLooper()).postDelayed({
                spinner.visibility = View.GONE
            },3000)

        }).start()
    }

}
