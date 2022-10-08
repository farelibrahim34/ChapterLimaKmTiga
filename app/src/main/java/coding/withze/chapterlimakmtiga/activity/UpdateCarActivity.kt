package coding.withze.chapterlimakmtiga.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import coding.withze.chapterlimakmtiga.R
import coding.withze.chapterlimakmtiga.databinding.ActivityAddCarBinding
import coding.withze.chapterlimakmtiga.databinding.ActivityUpdateCarBinding
import coding.withze.chapterlimakmtiga.viewmodel.ViewModelCar

class UpdateCarActivity : AppCompatActivity() {
    lateinit var binding : ActivityUpdateCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_update_car)
        binding = ActivityUpdateCarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var fetId = intent.getIntExtra("update", 0 )




        binding.btnUpdate.setOnClickListener {
            var fetId = intent.getIntExtra("update", 0 )
            var nama  = binding.addMobil.text.toString()
            var cat = binding.addCategory.text.toString()
            var price = binding.addPrice.text.toString()
            var status = binding.addStatus.text.toString()
            var img = binding.addImage.text.toString()

            updateDataCar(fetId,nama,cat,price.toInt(),status.toBoolean(),img)
            finish()

        }


    }
    fun updateDataCar(id : Int,name : String, category : String, price : Int, status : Boolean, image : String){
        var viewModel = ViewModelProvider(this).get(ViewModelCar::class.java)
        viewModel.updateApiCar(id, name, category, price, status, image)
        viewModel.putLiveData().observe(this,{
            Toast.makeText(this,"edit data sukses",Toast.LENGTH_SHORT).show()
        })

    }

}