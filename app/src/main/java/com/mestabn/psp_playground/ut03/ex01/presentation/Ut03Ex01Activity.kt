package com.mestabn.psp_playground.ut03.ex01.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.mestabn.psp_playground.R

class Ut03Ex01Activity : AppCompatActivity() {

    private val viewModel by viewModels<Ut03Ex01ViewModel>()
    private val TAG = Ut03Ex01Activity::class.java.simpleName
    private  lateinit var thread1 : Thread

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut03_ex01)
        //exampleThread()
        //onDestroy()
        exampleCoroutines()
    }


    private fun exampleThread(){
        thread1 = Thread(Runnable {
            var i = 0
            while (true){
                Log.d(TAG, "Hola: $i")
                Thread.sleep(1000)
                i +=1
            }
        })
        thread1.start()
    }

    private  fun exampleCoroutines(){
        viewModel.getUserViewModelScope()
    }

    override fun onDestroy() {
        super.onDestroy()
        //Deberiamos hacer esto para cancelar el hilo
        if(this::thread1.isInitialized){
            thread1.interrupt()
        }
    }
}