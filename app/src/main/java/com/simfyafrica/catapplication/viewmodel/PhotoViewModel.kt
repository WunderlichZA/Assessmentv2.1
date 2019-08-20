package com.simfyafrica.catapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.simfyafrica.catapplication.model.Photo
import com.simfyafrica.catapplication.repository.PhotoRepository
import com.simfyafrica.catapplication.roomdatabase.PhotoRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotoViewModel(application: Application) : AndroidViewModel(application) {

    private val repository : PhotoRepository
    val allPhotos : LiveData<List<Photo>>

    init {
        val photoDao = PhotoRoomDatabase.getDatabase(application).photoDAO()
        repository = PhotoRepository(photoDao)
        allPhotos = repository.allWords
    }

    fun insert(photo: Photo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(photo)
    }
}