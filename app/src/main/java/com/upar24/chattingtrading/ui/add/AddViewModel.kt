package com.upar24.chattingtrading.ui.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.upar24.chattingtrading.data.local.entities.Trading
import com.upar24.chattingtrading.repository.CTFRepository
import com.upar24.chattingtrading.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val repository: CTFRepository
): ViewModel(){
    private val _saveStatus = MutableLiveData<Resource<String>>()
    val saveStatus: LiveData<Resource<String>> = _saveStatus
    private val _deleteStatus = MutableLiveData<Resource<String>>()
    val deleteStatus:LiveData<Resource<String>> = _deleteStatus
    private val _allTradingStatus = MutableLiveData<Resource<List<Trading>>>()
    val allTradingStatus:LiveData<Resource<List<Trading>>> = _allTradingStatus
    private val _tradingStatus = MutableLiveData<Resource<Trading>>()
    val tradingStatus:LiveData<Resource<Trading>> = _tradingStatus
    private val _buyingSearchStatus = MutableLiveData<Resource<List<Trading>>>()
    val buyingSearchStatus:LiveData<Resource<List<Trading>>> = _buyingSearchStatus
    private val _sellingSearchStatus = MutableLiveData<Resource<List<Trading>>>()
    val sellingSearchStatus:LiveData<Resource<List<Trading>>> = _sellingSearchStatus
    private val _allUserTrading = MutableLiveData<Resource<List<Trading>>>()
    val allUserTrading:LiveData<Resource<List<Trading>>> = _allUserTrading
    private val _titleSearchStatus = MutableLiveData<Resource<List<Trading>>>()
    val titleSearchStatus:LiveData<Resource<List<Trading>>> = _titleSearchStatus
    private val _descSearchStatus = MutableLiveData<Resource<List<Trading>>>()
    val descSearchStatus:LiveData<Resource<List<Trading>>> = _descSearchStatus


    fun saveTrading(trading: Trading){
        _saveStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result=repository.saveTrading(trading)
            _saveStatus.postValue(result)
            getAllTrading()
        }
    }
    fun deleteTrading(trading: Trading){
        _deleteStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result=repository.deleteTrading(trading)
            _deleteStatus.postValue(result)
            getAllTrading()
        }
    }
    fun getAllTrading(){
        _allTradingStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result=repository.getAllTrading()
            _allTradingStatus.postValue(result)
        }
    }
    fun getAllUserTrading(username: String){
        _allUserTrading.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result=repository.getAllUserTrading(username)
            _allUserTrading.postValue(result)
        }
    }
    fun getTrading(trading: Trading){
        _tradingStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result=repository.getTrading(trading)
            _tradingStatus.postValue(result)
        }
    }
    fun getBuyingSearch(query: String){
        _buyingSearchStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result=repository.getBuyingSearch(query)
            _buyingSearchStatus.postValue(result)
        }
    }
    fun getSellingSearch(query: String){
        _sellingSearchStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result=repository.getSellingSearch(query)
            _sellingSearchStatus.postValue(result)
        }
    }
    fun getTitleSearch(query: String){
        _titleSearchStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result = repository.getTitleSearch(query)
            _titleSearchStatus.postValue(result)
        }
    }
    fun getDescriptionSearch(query: String){
        _descSearchStatus.postValue(Resource.loading(null))
        viewModelScope.launch {
            val result = repository.getDescriptionSearch(query)
            _descSearchStatus.postValue(result)
        }
    }

}