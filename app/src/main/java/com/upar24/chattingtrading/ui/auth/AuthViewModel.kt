package com.upar24.chattingtrading.ui.auth

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upar24.chattingtrading.data.remote.BasicAuthInterceptor
import com.upar24.chattingtrading.repository.CTFRepository
import com.upar24.chattingtrading.util.KangDooShik.KEY_LOGGED_IN_PASSWORD
import com.upar24.chattingtrading.util.KangDooShik.KEY_LOGGED_IN_USERNAME
import com.upar24.chattingtrading.util.KangDooShik.LOGIN
import com.upar24.chattingtrading.util.KangDooShik.LOGOUT
import com.upar24.chattingtrading.util.KangDooShik.NOTIMER
import com.upar24.chattingtrading.util.KangDooShik.NO_PASSWORD
import com.upar24.chattingtrading.util.KangDooShik.NO_USERNAME
import com.upar24.chattingtrading.util.KangDooShik.TIMERKEYPREF
import com.upar24.chattingtrading.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor (
    private val repository: CTFRepository
): ViewModel() {
    @Inject
    lateinit var sharedPref: SharedPreferences

    @Inject
    lateinit var basicAuthInterceptor: BasicAuthInterceptor

    var usernamevm: String? = null
    var passwordvm: String? = null



    private val _registerStatus = MutableLiveData<Resource<String>>()
    val registerStatus: LiveData<Resource<String>> = _registerStatus
    private val _loginStatus = MutableLiveData<Resource<String>>()
    val loginStatus: LiveData<Resource<String>> = _loginStatus

    fun loginUser(username:String,password:String){
        _loginStatus.postValue(Resource.loading(null))
        viewModelScope.launch{
            usernamevm=username
            passwordvm=password
            val result= repository.login(username,password)
            _loginStatus.postValue(result)
        }
    }

    fun registerUser(username:String,password:String){
        _registerStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result = repository.register(username, password)
            _registerStatus.postValue(result)
        }
    }
    fun timerLeft():Int{
        val timerpref=sharedPref.getString(TIMERKEYPREF, NOTIMER) ?: NOTIMER
        val timervm=if((timerpref.toLong() - System.currentTimeMillis()) /1000L  <= 0) 0L else (timerpref.toLong() - System.currentTimeMillis()) /1000L
        return timervm.toInt()
    }

    fun isLoggedIn():Boolean{
        usernamevm=sharedPref.getString(KEY_LOGGED_IN_USERNAME,NO_USERNAME) ?: NO_USERNAME
        passwordvm=sharedPref.getString(KEY_LOGGED_IN_PASSWORD, NO_PASSWORD) ?: NO_PASSWORD
        return usernamevm!= NO_USERNAME && passwordvm != NO_PASSWORD
    }
    fun authenticateApi(username:String, password: String){
        basicAuthInterceptor.username=username
        basicAuthInterceptor.password=password
    }

    private val _desc= MutableStateFlow("")
    var desc: StateFlow<String> = _desc
    fun getDesc()=viewModelScope.launch{
        isLoggedIn()
        val username =if(sharedPref.getString(KEY_LOGGED_IN_USERNAME,NO_USERNAME) == NO_USERNAME) LOGIN else LOGOUT
        _desc.value=username
    }
}

















