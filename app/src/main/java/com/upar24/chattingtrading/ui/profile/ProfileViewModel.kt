package com.upar24.chattingtrading.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upar24.chattingtrading.data.local.entities.User
import com.upar24.chattingtrading.data.local.entities.Wall
import com.upar24.chattingtrading.data.remote.requests.UpdateUserRequest
import com.upar24.chattingtrading.repository.CTFRepository
import com.upar24.chattingtrading.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: CTFRepository
): ViewModel(){
    private val _user = MutableLiveData<Resource<User>>()
    val user : LiveData<Resource<User>> = _user
    private val _updateProfile =MutableLiveData<Resource<String>>()
    val updateProfile : LiveData<Resource<String>> = _updateProfile
    private val _saveWallStatus = MutableLiveData<Resource<String>>()
    val saveWallStatus : LiveData<Resource<String>> = _saveWallStatus
    private val _getWallStatus = MutableLiveData<Resource<List<Wall>>>()
    val getWallStatus : LiveData<Resource<List<Wall>>> = _getWallStatus
    private val _deleteWallStatus = MutableLiveData<Resource<String>>()
    val deleteWallStatus : LiveData<Resource<String>> = _deleteWallStatus
    private val _listUserClubStatus = MutableLiveData<Resource<List<User>>>()
    val listUserClubStatus:LiveData<Resource<List<User>>> = _listUserClubStatus
    private val _listUserIgnStatus = MutableLiveData<Resource<List<User>>>()
    val listUserIgnStatus:LiveData<Resource<List<User>>> = _listUserIgnStatus
    private val _deletionStatus = MutableLiveData<Resource<String>>()
    val deletionStatus : LiveData<Resource<String>> = _deletionStatus


    fun getUser(username:String){
        _user.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result=repository.getUser(username)
            _user.postValue(result)
        }
    }

    fun updateProfile(updateUserReq: UpdateUserRequest, username:String){
        _updateProfile.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result=repository.updateProfile(updateUserReq)
            _updateProfile.postValue(result)
            getUser(username)
        }
    }

    fun saveWall(wall : Wall,username: String){
        _saveWallStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result= repository.saveWall(wall)
            _saveWallStatus.postValue(result)
            getWall(username)
        }
    }

    fun getWall(username: String){
        _getWallStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result= repository.getWall(username)
            _getWallStatus.postValue(result)
        }
    }
    fun deleteWall(username:String,wall:Wall){
        _deleteWallStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result=repository.deleteWall(wall)
            _deleteWallStatus.postValue(result)
            getWall(username)
        }
    }
    fun listUserClub(club:String){
        _listUserClubStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result = repository.getListUserClub(club)
            _listUserClubStatus.postValue(result)
        }
    }
    fun listUserIgn(ign:String){
        _listUserIgnStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result = repository.getListUserIgn(ign)
            _listUserIgnStatus.postValue(result)
        }
    }

}
