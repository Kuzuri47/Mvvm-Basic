package com.example.mvvm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.api.ApiInterface
import com.example.mvvm.api.RetrofitInstance
import com.example.mvvm.databinding.ActivityContactBinding
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.repository.UserRepository
import com.example.mvvm.viewmodel.ContactViewModel
import com.example.mvvm.viewmodel.ContactViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val service = RetrofitInstance.getInstance().create(ApiInterface::class.java)
        val repository = UserRepository(service)
        //Factory creates object
        viewModel = ViewModelProvider(this, ContactViewModelFactory(repository))[ContactViewModel::class.java]


        binding.button.setOnClickListener {
            val userName = binding.editTextTextPersonName3.text.toString()
            val password = binding.editTextTextPassword.text.toString()
            if (verify(userName, password)) {
                val intent = Intent(this, Contact::class.java)
                startActivity(intent)
            } else {
                binding.editTextTextPassword.text.clear()
                binding.editTextTextPersonName3.text.clear()
                Toast.makeText(this,"Username or password is invalid",Toast.LENGTH_LONG).show()

            }
        }
    }
    private fun verify(userName: String, password: String): Boolean{
        val username = viewModel.compareUsernameForLogin(userName)
        val password =   viewModel.comparePasswordForLogin(password)
        return username && password
    }

}