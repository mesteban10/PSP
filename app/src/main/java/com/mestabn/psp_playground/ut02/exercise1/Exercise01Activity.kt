package com.mestabn.psp_playground.ut02.exercise1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jmperezra.psp_playground.R
import com.mestabn.psp_playground.R
import com.mestabn.psp_playground.ut02.exercise1.data.UserRepository

class Exercise02Activity : AppCompatActivity() {

    private val TAG: String = Exercise02Activity::class.java.simpleName

    private val apiClientFactory: ApiClientFactory = ApiClientFactory()
    //Es lo mismo que en la linea anterior - > private val apiClientFactory = ApiClientFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise01)
        setupView()
    }

    private fun setupView() {
        val actionMock: Button = findViewById(R.id.action_mock)
        actionMock.setOnClickListener {
            runRepository(it.id)
        }

        val actionApi: Button = findViewById(R.id.action_api)
        actionApi.setOnClickListener {
            runRepository(it.id)
        }
    }

    private fun runRepository(actionId: Int) {
        //obtengo la abstracción del ApiClient a usar
        val userRepository = UserRepository(apiClientFactory.build(actionId))

        //Visualizo el listado de usuarios
        val users = userRepository.getUsers()
        users.forEach { userApiModel ->
            Log.d(TAG, "$userApiModel")
        }

        //Obtengo un usuario y visualizo el usuario
        val user = userRepository.getUser(1)
        user?.run {
            Log.d(TAG, "$this")
        }
    }
}