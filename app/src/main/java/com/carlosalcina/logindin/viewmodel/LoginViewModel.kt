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

    private val _emailError = MutableLiveData<Boolean>()
    val emailError = _emailError

    private val _passwordError = MutableLiveData<Boolean>()
    val passwordError = _passwordError

    private val _isPasswordVisible = MutableLiveData<Boolean>()
    val isPasswordVisible = _isPasswordVisible

    fun onEmailChanged(email: String){
        _email.value = email
    }

    fun onPasswordChanged(password: String){
        _password.value = password
    }

    fun changePasswordVisibility(visibility:Boolean){
        _isPasswordVisible.value = visibility
    }


    fun enableLogin(email: String, password: String): Boolean{
        return passwordError.value == true && emailError.value == true
    }
}