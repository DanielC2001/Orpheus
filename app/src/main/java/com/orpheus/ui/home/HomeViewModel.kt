package com.orpheus.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _songs = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val songs: LiveData<String> = _songs
}