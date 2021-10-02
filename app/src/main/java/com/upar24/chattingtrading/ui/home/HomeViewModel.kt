package com.upar24.chattingtrading.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upar24.chattingtrading.data.local.entities.*
import com.upar24.chattingtrading.repository.CTFRepository
import com.upar24.chattingtrading.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CTFRepository
): ViewModel(){
    private val _saveChatStatus = MutableLiveData<Resource<String>>()
    val saveChatStatus : LiveData<Resource<String>> = _saveChatStatus
    private val _getChatStatus = MutableLiveData<Resource<List<Chat>>>()
    val getChatStatus : LiveData<Resource<List<Chat>>> = _getChatStatus
    private val _savePartyStatus = MutableLiveData<Resource<String>>()
    val savePartyStatus : LiveData<Resource<String>> = _savePartyStatus
    private val _partyListStatus = MutableLiveData<Resource<List<Party>>>()
    val partyListStatus : LiveData<Resource<List<Party>>> = _partyListStatus
    private val _saveDropStatus = MutableLiveData<Resource<String>>()
    val saveDropStatus : LiveData<Resource<String>> = _saveDropStatus
    private val _dropListStatus = MutableLiveData<Resource<List<Dropped>>>()
    val dropListStatus : LiveData<Resource<List<Dropped>>> = _dropListStatus
    private val _saveTodayStatus = MutableLiveData<Resource<String>>()
    val saveTodayStatus : LiveData<Resource<String>> = _saveTodayStatus
    private val _todayStatus = MutableLiveData<Resource<Today>>()
    val todayStatus : LiveData<Resource<Today>> = _todayStatus
    private val _deleteDropStatus = MutableLiveData<Resource<String>>()
    val deleteDropStatus : LiveData<Resource<String>> = _deleteDropStatus
    private val _listUserStatus = MutableLiveData<Resource<List<User>>>()
    val listUserStatus : LiveData<Resource<List<User>>> = _listUserStatus

    fun getListUser(listString:List<String>){
        _listUserStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result = repository.getListUser(listString)
            _listUserStatus.postValue(result)
        }
    }
    fun saveChat(chat: Chat){
        _saveChatStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result=repository.saveChat(chat)
            _saveChatStatus.postValue(result)
            getChat()
        }
    }
    fun getChat(){
        _getChatStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result = repository.getChat()
            _getChatStatus.postValue(result)
        }
    }
    fun getPartyList(query:String){
        _partyListStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result = repository.getPartyList(query)
            _partyListStatus.postValue(result)
        }
    }
    fun getDropList(){
        _dropListStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result = repository.getDropList()
            _dropListStatus.postValue(result)
        }
    }
    fun getToday(){
        _todayStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result = repository.getToday()
            _todayStatus.postValue(result)
        }
    }
    fun toggleCheck(query: String,party: Party)=viewModelScope.launch {
        repository.toggleCheck(party)
        getPartyList(query)
    }

    fun toggleDrop(query: String,party: Party)= viewModelScope.launch {
        repository.toggleDrop(party)
        getPartyList(query)
    }

    fun toggleNope(query:String,party: Party)=viewModelScope.launch {
        repository.toggleNope(party)
        getPartyList(query)
    }

}