package com.example.android.codelabs.paging.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "pokemon_table")
data class Pokemon(

        @PrimaryKey @field:SerializedName("name") val name:String,
        @field:SerializedName("url") val url:String
)