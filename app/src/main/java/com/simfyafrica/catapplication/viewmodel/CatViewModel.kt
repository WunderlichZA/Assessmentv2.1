package com.simfyafrica.catapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simfyafrica.catapplication.model.CatImage
import com.simfyafrica.catapplication.networking.ApiFactory
import com.simfyafrica.catapplication.repository.CatRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CatViewModel : ViewModel() {

    private val parentJob = Job()

    private val coroutineContext : CoroutineContext
        get() = parentJob + Dispatchers.Default

    private  val scope = CoroutineScope(coroutineContext)

    private val repository :  CatRepository = CatRepository(ApiFactory.catApi)

    val catImagesLiveData = MutableLiveData<MutableList<CatImage>>()

    fun fetchCatImages(){
        scope.launch {
            val catImages = repository.getCatImages()
            catImagesLiveData.postValue(catImages)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}