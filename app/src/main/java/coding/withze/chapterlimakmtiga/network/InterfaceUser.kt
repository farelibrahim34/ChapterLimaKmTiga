package coding.withze.chapterlimakmtiga.network

import coding.withze.chapterlimakmtiga.model.ResponseDataUserItem
import retrofit2.Call
import retrofit2.http.GET

interface InterfaceUser {

    @GET("user")
    fun getAllUser(): Call<List<ResponseDataUserItem>>

}