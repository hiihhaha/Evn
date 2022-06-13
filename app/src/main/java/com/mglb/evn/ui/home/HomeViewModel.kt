package com.mglb.evn.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mglb.evn.model.StaffModel
import com.mglb.evn.repository.StaffRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private var staffRepository: StaffRepository = StaffRepository()
):ViewModel() {
    var staffResponseLiveData = MutableLiveData<MutableList<StaffModel>>()


    fun getAlStaff(){
        viewModelScope.launch ( Dispatchers.IO ){
            staffResponseLiveData.postValue(staffRepository.getAllStaff())

        }
    }
    fun search(textSearch : String){
        viewModelScope.launch ( Dispatchers.IO ) {
            staffResponseLiveData.postValue(staffRepository.searchStaff(textSearch))


        }
    }
}