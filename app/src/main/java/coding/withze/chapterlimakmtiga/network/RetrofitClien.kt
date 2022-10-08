package coding.withze.chapterlimakmtiga.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClien {

    const val BASE_URL = "https://rent-cars-api.herokuapp.com/"

    val instance : RestfulApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(RestfulApi::class.java)
    }



}