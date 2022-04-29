package com.example.mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.api.ApiInterface
import com.example.mvvm.model.Users

class UserRepository(private val apiInterface: ApiInterface) {


    private val users = MutableLiveData<List<Users>>()
    val response = users

    suspend fun getAllUsers(){
        val result = apiInterface.getUsers()
        if (result.body() != null){
//            users.value = result.body()
            users.postValue(result.body())
        }
    }
}