package com.slbrazil.baseapp.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val searchInput : MutableLiveData<String> = MutableLiveData<String>()


    fun setSearchInput(text: String){

        searchInput.value = text;
        Log.d("MainViewModel", "search input: $text" )
    }

    fun getSearchInput() :LiveData<String>{

        return searchInput;
    }


}