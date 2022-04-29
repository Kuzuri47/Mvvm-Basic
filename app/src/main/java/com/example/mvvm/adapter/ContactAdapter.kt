package com.example.mvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.databinding.ItemViewBinding
import com.example.mvvm.model.Users

class ContactAdapter: RecyclerView.Adapter<ContactViewHolder>() {
    var itemsList = listOf<Users>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
       holder.bind(itemsList[position] as Users)
    }

    override fun getItemCount(): Int = itemsList.size
}