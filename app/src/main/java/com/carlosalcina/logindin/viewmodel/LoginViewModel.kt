package com.carlosalcina.logindin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password = _password

    private val _isLoginEnabled = MutableLiveData<Boolean>()
    val isLoginEnabled = _isLoginEnabled

    fun onLoginChanged(email: String, password: String){
        _email.value = email
        _password.value = password
        _isLoginEnabled.value = enableLogin(email, password)
    }

    fun enableLogin(email: String, password: String): Boolean{
        return true
    }
}