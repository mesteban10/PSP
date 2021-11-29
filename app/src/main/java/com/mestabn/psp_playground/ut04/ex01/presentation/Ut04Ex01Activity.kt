package com.mestabn.psp_playground.ut04.ex01.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.mestabn.psp_playground.databinding.ActivityUt04Ex01Binding

class Ut04Ex01Activity : AppCompatActivity() {

    private val binding: ActivityUt04Ex01Binding by lazy {
        ActivityUt04Ex01Binding.inflate(layoutInflater)
    }

    private val viewModel: Ut04Ex01ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupView()
        setupViewStateObservers()
    }

    private fun setupView() {
        binding.actionLivedata.setOnClickListener {
            viewModel.loadData()
        }
    }

    /**
     * Este método debería ser ejecutado una única vez. Es por eso que, dentro del ciclo de vida
     * de la actividad, el mejor momento es en el onCreate.
     */
    private fun setupViewStateObservers() {
        // Se crea el observador. Hay que indicar qué voy a recibir del observador.
        val nameObserver = Observer<AlertViewState> { alertViewState ->
            // Actualiamos la UI con los datos recibidos desde el LiveData (Observer)
            Toast.makeText(this, alertViewState.name, Toast.LENGTH_SHORT).show()
        }

        // Observamos al LiveData declarado en el ViewModel
        viewModel.alertViewState.observe(this, nameObserver)
    }
}