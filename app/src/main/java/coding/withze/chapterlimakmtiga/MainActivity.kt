package coding.withze.chapterlimakmtiga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coding.withze.chapterlimakmtiga.activity.AddCarActivity
import coding.withze.chapterlimakmtiga.adapter.CarAdapter
import coding.withze.chapterlimakmtiga.databinding.ActivityMainBinding
import coding.withze.chapterlimakmtiga.viewmodel.ViewModelCar

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : ViewModelCar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showDataCar()



    }
    fun showDataCar(){

        viewModel = ViewModelProvider(this).get(ViewModelCar::class.java)
        viewModel.getLiveDataCa().observe(this, {
            if (it != null){
                binding.rvCar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvCar.adapter = CarAdapter(it)
                val adapter = CarAdapter(it)
                adapter.onDeleteClick = {
                    deleteCar(it.id.toInt())
                }
                adapter.notifyDataSetChanged()
            }
        })
        viewModel.callApiCar()

    }

    fun deleteCar(id: Int){
        viewModel.deleteApiCar(id)
        viewModel.getLiveDataCa().observe(this,{
            if (it != null){
                showDataCar()
                Toast.makeText(this, "Data berhasil dihapus", Toast.LENGTH_SHORT).show()
            }
        })

    }
}