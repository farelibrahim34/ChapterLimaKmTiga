package coding.withze.chapterlimakmtiga.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import coding.withze.chapterlimakmtiga.model.ResponseDataUserItem
import coding.withze.chapterlimakmtiga.network.RetroDua
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelUser: ViewModel() {
    lateinit var liveDataUser : MutableLiveData<List<ResponseDataUserItem>>

    init {
        liveDataUser = MutableLiveData()
    }

    fun getDataUser():MutableLiveData<List<ResponseDataUserItem>>{
        return liveDataUser
    }

    fun callApiUser(){
        RetroDua.instance.getAllUser()
            .enqueue(object : Callback<List<ResponseDataUserItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataUserItem>>,
                    response: Response<List<ResponseDataUserItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataUser.postValue(response.body())
                    }else{
                        liveDataUser.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataUserItem>>, t: Throwable) {
                    liveDataUser.postValue(null)
                }

            })

    }



}