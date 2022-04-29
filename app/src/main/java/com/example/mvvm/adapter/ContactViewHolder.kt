package com.example.mvvm.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.mvvm.databinding.ActivityContactBinding
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.databinding.ItemViewBinding
import com.example.mvvm.model.Users

class ContactViewHolder(var binding: ItemViewBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(users: Users){
        binding.name.text = users.username
        binding.contact.text = users.phone
        binding.email.text = users.email
    }
}