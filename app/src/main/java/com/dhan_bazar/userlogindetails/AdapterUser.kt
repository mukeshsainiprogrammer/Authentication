package com.dhan_bazar.userlogindetails

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.dhan_bazar.userlogindetails.databinding.UserItemBinding

class AdapterUser(private val modelList: List<UserModelsItem>) : RecyclerView.Adapter<AdapterUser.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val model = modelList[position]
        holder.binding.apply {
            id.text = "Id = ${model.id}"
            userid.text = "User Id = ${model.userId}"
            title.text = "Title = ${model.title}"
            body.text = "Body = ${model.body}"
        }

        holder.binding.clickBtn.setOnClickListener {
           /* val intent = Intent(context, DataShowActivity::class.java).apply {
                putExtra("Id", model.id)
                putExtra("userId", model.userID)
                putExtra("title", model.title)
                putExtra("body", model.body)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }*/
           // context.startActivity(intent)
         //   Toast.makeText(context, "This is Show id = ${model.id}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = modelList.size

    class MyHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)
}
