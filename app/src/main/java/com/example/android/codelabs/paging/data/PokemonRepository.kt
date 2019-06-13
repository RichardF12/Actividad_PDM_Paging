package com.example.android.codelabs.paging.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.android.codelabs.paging.api.PokemonService
import com.example.android.codelabs.paging.db.PokemonDao
import com.example.android.codelabs.paging.model.Pokemon
import com.example.android.codelabs.paging.model.PokemonResult
import retrofit2.Response

class PokemonRepository(private val pokemonDao: PokemonDao,private val pokemonService: PokemonService) {


    fun insert(pokemon: Pokemon){
        pokemonDao.insert(pokemon)
    }

    fun getAll():LiveData<PagedList<Pokemon>>{
        return pokemonDao.getAll()
    }

    fun retrieveAll(): Response<List<PokemonResult>>{
        return pokemonService.getPokemon()
    }

}