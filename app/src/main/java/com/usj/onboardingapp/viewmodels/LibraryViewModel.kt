package com.usj.onboardingapp.viewmodels

import android.R.attr.delay
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.usj.onboardingapp.model.Library
import com.usj.onboardingapp.model.MediaItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay

class LibraryViewModel: ViewModel() {
    private val _libraryItems = MutableLiveData<List<MediaItem>>()
    val libraryItems: LiveData<List<MediaItem>> = _libraryItems


    fun fetchLibraryItems(){
        _libraryItems.value = Library().allItems
    }

}