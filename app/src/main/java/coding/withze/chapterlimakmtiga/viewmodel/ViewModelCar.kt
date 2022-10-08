package coding.withze.chapterlimakmtiga.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import coding.withze.chapterlimakmtiga.model.DataCar
import coding.withze.chapterlimakmtiga.model.PostResponCar
import coding.withze.chapterlimakmtiga.model.PutResponseCar
import coding.withze.chapterlimakmtiga.model.ResponseDataCarItem
import coding.withze.chapterlimakmtiga.network.RetrofitClien
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCar : ViewModel() {

    lateinit var  liveDataCar : MutableLiveData<List<ResponseDataCarItem>>
    lateinit var postLDataCar : MutableLiveData<PostResponCar>
    lateinit var putLDCar : MutableLiveData<List<PutResponseCar>>
    lateinit var deleteLdCar : MutableLiveData<ResponseDataCarItem>

    init {
        liveDataCar = MutableLiveData()
        postLDataCar = MutableLiveData()
        putLDCar = MutableLiveData()
        deleteLdCar = MutableLiveData()
    }
    fun deleteLivedataCar(): MutableLiveData<ResponseDataCarItem>{
        return deleteLdCar
    }

    fun putLiveData(): MutableLiveData<List<PutResponseCar>>{
        return  putLDCar
    }

    fun getLiveDataCa():MutableLiveData<List<ResponseDataCarItem>>{
        return liveDataCar
    }
    fun postLiveDataCar():MutableLiveData<PostResponCar>{
        return postLDataCar
    }

    fun deleteApiCar(id : Int){
        RetrofitClien.instance.deleteDataCar(id)
            .enqueue(object : Callback<ResponseDataCarItem>{
                override fun onResponse(
                    call: Call<ResponseDataCarItem>,
                    response: Response<ResponseDataCarItem>
                ) {
                    if (response.isSuccessful){
                        deleteLdCar.postValue(response.body())
                    }else{
                        deleteLdCar.postValue(null)
                    }
                }

                override fun onFailure(call: Call<ResponseDataCarItem>, t: Throwable) {
                    deleteLdCar.postValue(null)
                }

            })

    }


    fun updateApiCar(id: Int,name : String, category : String, price : Int, status : Boolean, image : String){
        RetrofitClien.instance.updateDataCar(id, DataCar(name, category, price, status, image))
            .enqueue(object  : Callback<List<PutResponseCar>>{
                override fun onResponse(
                    call: Call<List<PutResponseCar>>,
                    response: Response<List<PutResponseCar>>
                ) {
                    if (response.isSuccessful){
                        putLDCar.postValue(response.body())
                    }else{
                        putLDCar.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<PutResponseCar>>, t: Throwable) {
                    putLDCar.postValue(null)
                }

            })
    }

    fun callPostApiCar(name : String, category : String, price : Int, status : Boolean, image : String){

        RetrofitClien.instance.addDataCar(DataCar(name, category, price, status, image))
            .enqueue(object  : Callback<PostResponCar>{
                override fun onResponse(
                    call: Call<PostResponCar>,
                    response: Response<PostResponCar>
                ) {
                    if (response.isSuccessful){
                        postLDataCar.postValue(response.body())
                    }else{
                        postLDataCar.postValue(null)
                    }
                }

                override fun onFailure(call: Call<PostResponCar>, t: Throwable) {
                    postLDataCar.postValue(null)
                }

            })




    }


    fun callApiCar(){
        RetrofitClien.instance.getAllCar()
            .enqueue(object  : Callback<List<ResponseDataCarItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataCarItem>>,
                    response: Response<List<ResponseDataCarItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataCar.postValue(response.body())
                    }else{
                        liveDataCar.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataCarItem>>, t: Throwable) {
                    liveDataCar.postValue(null)
                }

            })


    }

}