package com.simfyafrica.catapplication.repository

import com.simfyafrica.catapplication.model.CatImage
import com.simfyafrica.catapplication.networking.CatApi

class CatRepository (private val api : CatApi) : BaseRepository() {

    suspend fun getCatImages() : MutableList<CatImage>?{

        val catResponse = safeApiCall(
            call = {api.getImages("json", 100, "small", "png").await()},
            errorMessage = "Error fetching popular movies"
        )
        return catResponse?.results?.toMutableList()
    }
}