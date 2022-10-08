package coding.withze.chapterlimakmtiga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import coding.withze.chapterlimakmtiga.activity.AddCarActivity
import coding.withze.chapterlimakmtiga.adapter.CarAdapter
import coding.withze.chapterlimakmtiga.databinding.ActivityListCarBinding
import coding.withze.chapterlimakmtiga.model.ResponseDataCarItem
import coding.withze.chapterlimakmtiga.network.RetrofitClien
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListCarActivity : AppCompatActivity() {

    lateinit var binding : ActivityListCarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataCar()
        binding.addButton.setOnClickListener {
            var intent = Intent(this,AddCarActivity::class.java)
            startActivity(intent)
        }


    }

    fun  dataCar(){
        RetrofitClien.instance.getAllCar()
            .enqueue(object  : Callback<List<ResponseDataCarItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataCarItem>>,
                    response: Response<List<ResponseDataCarItem>>
                ) {
                    if (response.isSuccessful){
                        binding.rvCar.layoutManager = LinearLayoutManager(this@ListCarActivity, LinearLayoutManager.VERTICAL, false)
                        binding.rvCar.adapter = CarAdapter(response.body()!!)
                    }else{
                        Toast.makeText(this@ListCarActivity, "Load Data Failed", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<List<ResponseDataCarItem>>, t: Throwable) {
                    Toast.makeText(this@ListCarActivity, "Something Wrong", Toast.LENGTH_SHORT).show()
                }

            })
    }
}