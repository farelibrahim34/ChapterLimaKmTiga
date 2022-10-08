package coding.withze.chapterlimakmtiga.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroDua {

    const val BASE_url = "https://6254434289f28cf72b5aed04.mockapi.io/"

    val instance : InterfaceUser by lazy {
        val retroDua = Retrofit.Builder()
            .baseUrl(BASE_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retroDua.create(InterfaceUser::class.java)
    }

}