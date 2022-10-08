package coding.withze.chapterlimakmtiga.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import coding.withze.chapterlimakmtiga.R
import coding.withze.chapterlimakmtiga.databinding.ActivityAddCarBinding
import coding.withze.chapterlimakmtiga.viewmodel.ViewModelCar

class AddCarActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddCarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_add_car)
        binding = ActivityAddCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            var nama  = binding.addMobil.text.toString()
            var cat = binding.addCategory.text.toString()
            var price = binding.addPrice.text.toString()
            var status = binding.addStatus.text.toString()
            var img = binding.addImage.text.toString()
            addCar(nama,cat,price.toInt(),status.toBoolean(),img)

        }

    }

    fun addCar(name : String, category : String, price : Int, status : Boolean, image : String){
        var viewModel = ViewModelProvider(this).get(ViewModelCar::class.java)
        viewModel.callPostApiCar(name, category, price, status, image)
        viewModel.postLiveDataCar().observe(this,{
            if (it != null){
                Toast.makeText(this,"add data sukses",Toast.LENGTH_SHORT).show()
            }
        })
    }
}