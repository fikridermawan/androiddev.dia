package com.example.projectexam.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.projectexam.databinding.ItemAppliBinding
import com.example.projectexam.model.AppliModel

class AppliAdapter (private var appliList: ArrayList<AppliModel>): RecyclerView.Adapter<AppliAdapter.ViewHolder>(){
    inner class ViewHolder(val binding: ItemAppliBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemAppliBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val appli = appliList[position]
        with(holder){
            binding.txJob.text = appli.appliJob
            binding.txCompany.text = appli.appliCompany
            binding.ivAppli.setImageResource(appli.appliImg)
        }
    }

    override fun getItemCount(): Int {
        return appliList.size
    }
}