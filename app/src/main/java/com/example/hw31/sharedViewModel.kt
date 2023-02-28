package com.example.hw31

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private var _fullName = MutableLiveData("")
    val fullName: LiveData<String> = _fullName
    private var _userName = MutableLiveData("")
    val userName: LiveData<String> = _userName
    private var _email = MutableLiveData("")
    val email: LiveData<String> = _email
    private var _password = MutableLiveData("")
    val password: LiveData<String> = _password
    private var _rePass = MutableLiveData("")
    val rePass: LiveData<String> = _rePass
    private var _gender = MutableLiveData("")
    val gender: LiveData<String> = _gender


    fun setFullNAme(s: String) {
        _fullName.value = s
    }

    fun setUserName(s: String) {
        _userName.value = s
    }

    fun setEmail(s: String) {
        _email.value = s
    }

    fun setPassword(s: String) {
        _password.value = s
    }

    fun setRePass(s: String) {
        _rePass.value = s
    }

    fun setGender(s: String) {
        _gender.value = s
    }
}