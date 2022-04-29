package com.example.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.model.Users
import com.example.mvvm.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val name = "Ashish Vishwakarma"
private const val password = "1234"
class ContactViewModel(private val userRepository: UserRepository): ViewModel() {

    private  var user = MutableLiveData<List<Users>>()
    var allUser = user
    init {
        viewModelScope.launch(Dispatchers.IO){
            userRepository.getAllUsers()
        }
        allUser = userRepository.response
    }

    fun compareUsernameForLogin(enteredValue: String): Boolean {
        return enteredValue == name
    }
    fun comparePasswordForLogin(enteredValue: String): Boolean {
        return enteredValue == password
    }

}