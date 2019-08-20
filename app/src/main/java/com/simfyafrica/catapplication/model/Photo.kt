package com.simfyafrica.catapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo_table")
class Photo (
    @PrimaryKey @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "url") val photoUrl: String,
    @ColumnInfo(name = "description") val description: String)