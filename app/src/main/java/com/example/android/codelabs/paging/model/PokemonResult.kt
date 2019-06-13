package com.example.android.codelabs.paging.model

import androidx.paging.PagedList
import com.google.gson.annotations.SerializedName

data class PokemonResult(

        @field:SerializedName("results") val results : List<Pokemon>
) {
}