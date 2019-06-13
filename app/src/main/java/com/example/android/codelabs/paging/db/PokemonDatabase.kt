package com.example.android.codelabs.paging.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.codelabs.paging.model.Pokemon

@Database(entities = [Pokemon::class],version = 1,exportSchema = false)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun pokemonDao():PokemonDao

    companion object{

        @Volatile
        private var INSTANCE:PokemonDatabase ?= null

        fun getInstance(context: Context):PokemonDatabase{

            if(INSTANCE != null){
                return INSTANCE!!
            }else{
                INSTANCE = Room.databaseBuilder(context,PokemonDatabase::class.java,"pokemonDatabase")
                        .build()
                return INSTANCE!!
            }

        }



    }

}