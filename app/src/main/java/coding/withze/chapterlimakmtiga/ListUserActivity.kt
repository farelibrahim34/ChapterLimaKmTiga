package coding.withze.chapterlimakmtiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coding.withze.chapterlimakmtiga.adapter.UserAdapter
import coding.withze.chapterlimakmtiga.databinding.ActivityListCarBinding
import coding.withze.chapterlimakmtiga.databinding.ActivityListUserBinding
import coding.withze.chapterlimakmtiga.viewmodel.ViewModelUser

class ListUserActivity : AppCompatActivity() {
    lateinit var binding : ActivityListUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataUser()

    }

    fun dataUser(){
        val viewModel = ViewModelProvider(this).get(ViewModelUser::class.java)
        viewModel.getDataUser().observe(this, {
            if (it != null){
                binding.rvUser.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                binding.rvUser.adapter = UserAdapter(it)
            }
        })
        viewModel.callApiUser()
    }

}