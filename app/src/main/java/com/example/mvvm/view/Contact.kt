package com.example.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.R
import com.example.mvvm.adapter.ContactAdapter
import com.example.mvvm.api.ApiInterface
import com.example.mvvm.api.RetrofitInstance
import com.example.mvvm.databinding.ActivityContactBinding
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.repository.UserRepository
import com.example.mvvm.viewmodel.ContactViewModel
import com.example.mvvm.viewmodel.ContactViewModelFactory

class Contact : AppCompatActivity() {
    lateinit var contactViewModel: ContactViewModel
    lateinit var binding: ActivityContactBinding
    private val myadapter = ContactAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_contact)
        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.contactRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@Contact)
            adapter = myadapter
        }

        val service = RetrofitInstance.getInstance().create(ApiInterface::class.java)
        val repository = UserRepository(service)
        //Factory creates object
        contactViewModel = ViewModelProvider(this, ContactViewModelFactory(repository))[ContactViewModel::class.java]
        observeContacts()
    }
    private fun observeContacts(){
        contactViewModel.allUser.observe(this, Observer {
            myadapter.itemsList = it

        })
    }
}