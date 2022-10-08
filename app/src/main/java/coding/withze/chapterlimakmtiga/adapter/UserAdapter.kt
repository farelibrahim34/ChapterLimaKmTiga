package coding.withze.chapterlimakmtiga.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coding.withze.chapterlimakmtiga.databinding.ItemUserBinding

import coding.withze.chapterlimakmtiga.model.ResponseDataUserItem

class UserAdapter(var listUser : List<ResponseDataUserItem>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    class ViewHolder(var binding: ItemUserBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtUser.text = listUser[position].name
    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}