package com.example.android.codelabs.paging.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.android.codelabs.paging.api.PokemonService
import com.example.android.codelabs.paging.data.PokemonRepository
import com.example.android.codelabs.paging.db.PokemonDatabase
import com.example.android.codelabs.paging.model.Pokemon
import com.example.android.codelabs.paging.model.PokemonResult
import retrofit2.Response

class PokemonViewModel(app:Application):AndroidViewModel(app) {

    val repository:PokemonRepository

    init {
        val pokemonDao = PokemonDatabase.getInstance(app).pokemonDao()
        val pokemonServie = PokemonService.create()
        repository = PokemonRepository(pokemonDao,pokemonServie)
    }

    fun insert(pokemon:Pokemon){
        repository.insert(pokemon)
    }

    fun getAll(): LiveData<List<Pokemon>>{
        return repository.getAll()
    }

    fun retriveAll(){
        val response = repository.retrieveAll()
        if(response.isSuccessful)with(response){
            val pokemonResultList = this.body()?.get(0)
            val pokemonList = pokemonResultList?.results

            pokemonList?.forEach { pokemon ->{
                this@PokemonViewModel.insert(pokemon)
            } }
        }
    }


}