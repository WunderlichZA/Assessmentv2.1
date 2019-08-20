package com.simfyafrica.catapplication.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.simfyafrica.catapplication.dao.PhotoDAO
import com.simfyafrica.catapplication.model.Photo

class PhotoRepository (private val photoDAO: PhotoDAO){

    val allWords: LiveData<List<Photo>> = photoDAO.getAllPhotos()

    @WorkerThread
    suspend fun insert(photo: Photo) {
        photoDAO.insert(photo)
    }
}