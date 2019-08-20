package com.simfyafrica.catapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simfyafrica.catapplication.adapter.PhotoAdapter
import com.simfyafrica.catapplication.viewmodel.CatViewModel

class MainActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var catViewModel: CatViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        catViewModel = ViewModelProviders.of(this).get(CatViewModel::class.java)

        catViewModel.fetchCatImages()

        catViewModel.catImagesLiveData.observe(this, Observer {

        })

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = PhotoAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
