package com.orpheus.ui.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PlaylistsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Here are your playlists!"
    }
    val text: LiveData<String> = _text
}