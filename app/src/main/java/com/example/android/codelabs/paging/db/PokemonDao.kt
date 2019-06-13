package com.example.android.codelabs.paging.db

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.codelabs.paging.model.Pokemon

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pokemon:Pokemon)


    @Query("SELECT * from pokemon_table")
    fun getAll(): LiveData<List<Pokemon>>

}