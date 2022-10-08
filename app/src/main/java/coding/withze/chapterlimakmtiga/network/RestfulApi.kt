package coding.withze.chapterlimakmtiga.network

import coding.withze.chapterlimakmtiga.model.DataCar
import coding.withze.chapterlimakmtiga.model.PostResponCar
import coding.withze.chapterlimakmtiga.model.PutResponseCar
import coding.withze.chapterlimakmtiga.model.ResponseDataCarItem
import retrofit2.Call
import retrofit2.http.*

interface RestfulApi {

    @GET("admin/car")
    fun getAllCar() : Call<List<ResponseDataCarItem>>

    @POST("admin/car")
    fun addDataCar(@Body request : DataCar) : Call<PostResponCar>

    @PUT("admin/car/{id}")
    fun updateDataCar(@Path("id") id : Int,@Body request : DataCar) : Call<List<PutResponseCar>>

    @DELETE("admin/car/{id}")
    fun deleteDataCar(@Path("id") id : Int): Call<ResponseDataCarItem>

}