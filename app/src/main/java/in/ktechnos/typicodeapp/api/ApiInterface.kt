package `in`.ktechnos.typicodeapp.api

import `in`.ktechnos.typicodeapp.model.Photos
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/photos")
    suspend fun getUserData() : Response<List<Photos>>
}