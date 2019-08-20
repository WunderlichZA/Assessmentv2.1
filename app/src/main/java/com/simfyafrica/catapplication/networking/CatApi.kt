package com.simfyafrica.catapplication.networking

import com.simfyafrica.catapplication.model.PhotoResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {

    @GET("get?")
    fun getImages(
        @Query("format") format: String,
        @Query("results_per_page") resultsPerPage: Int,
        @Query("size") size: String,
        @Query("type") type: String
    ) : Deferred<Response<PhotoResponse>>
}