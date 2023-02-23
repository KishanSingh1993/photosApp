package `in`.ktechnos.typicodeapp

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/photos")
    suspend fun getUserData() : Response<List<Photos>>
}