package com.mestabn.psp_playground.ut02

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.security.auth.callback.Callback


/**
 * Abstraccion del cliente qie vamos a usar en la actividad
 */
interface ApiClient {
    fun getUsers(): List<UserApiModel>
    fun getPosts(): List<PostApiModel>
    fun getUser(userId: Int): UserApiModel?
}

/**
 * Detalle de un cliente que nos devuelve datos establecidos a mano
 * Se suele usar para realizar pruebas
 */

class MockApiClient : ApiClient {
    override fun getUsers(): List<UserApiModel> {
        return mutableListOf(
            UserApiModel(1, "Usuario1", "user1", "user@email.es"),
            UserApiModel(2, "Usuario1", "user2", "user@email.es"),
            UserApiModel(3, "Usuario1", "user3", "user@email.es"),
            UserApiModel(4, "Usuario1", "user4", "user@email.es"),

            )
    }

    override fun getPosts(): List<PostApiModel> {
        return mutableListOf(
            PostApiModel(1, 1, "user1", "user@email.es"),
            PostApiModel(2, 2, "user1", "user@email.es"),
            PostApiModel(3, 3, "user1", "user@email.es"),
            PostApiModel(4, 4, "user1", "user@email.es"),


            )
    }

    override fun getUser(userId: Int): UserApiModel {
        return UserApiModel(1, "Usuario1", "user1", "user@email.es")

    }
}

/**
 * Uso de la librería Retrofit como cliente REST API. Accede a la API y recoge los datos.
 */
class RetrofitApiClient : ApiClient {

    private val urlEndPoint: String = "https://jsonplaceholder.typicode.com/" //URL del proyecto
    private var apiEndPoint: ApiEndPoint  //Interfaz necesaria de retrofit

    init {
        apiEndPoint = buildApiService() //Creo en objeto retrofit
    }

    /**
     * Creación del cliente con el Endpoint.
     * Definido por la librería Retrofit. Siempre es así.
     */
    private fun buildApiService(): ApiEndPoint {
        return buildClient().create(ApiEndPoint::class.java) //llamo a retrofit, y la creo con la interfaz ApiEndPoint
    }

    /**
     * Creación y configuración del cliente Retrofit.
     * Siempre es así.
     */
    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint) //Establezco URL de la API
            .addConverterFactory(GsonConverterFactory.create()) //Usamos GSon
            .build()
    }

    //Los dos metodos anteriores crean un objeto retrofit

    /**
     * EnPoint para obtener un listado de usuarios
     * @return List<UserPaiModel> listado de usuarios
     */

    override fun getUsers(): List<UserApiModel> {
        val call = apiEndPoint.getUsers()
        val response = call.execute()
        if (response.isSuccessful) {
            val users = response.body()
            return users ?: mutableListOf()
        } else {
            return mutableListOf()
        }
    }

    override fun getPosts(): List<PostApiModel> {
        val call = apiEndPoint.getPost()
        val response = call.execute()
        if (response.isSuccessful) {
            val posts = response.body()
            return posts ?: mutableListOf()
        } else {
            return mutableListOf()
        }
    }


    override fun getUser(userId: Int): UserApiModel? {
        val call = apiEndPoint.getUser(userId)
        val response = call.execute()
        return if (response.isSuccessful) {
            response.body()
        } else {
            null
        }
    }


}






