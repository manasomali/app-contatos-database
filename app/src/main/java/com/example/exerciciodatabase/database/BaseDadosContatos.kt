package com.example.exerciciodatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.exerciciodatabase.AccessContatos
import com.example.exerciciodatabase.Contato

@Database(entities = [Contato::class], version = 1, exportSchema=false)
abstract class BaseDadosContatos: RoomDatabase(){

    abstract fun contatoDAO(): AccessContatos

    companion object {
        @Volatile
        private var instance: BaseDadosContatos? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
            instance
                ?: buildDatabase(
                    context
                )
                    .also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            BaseDadosContatos::class.java, "app_data_base.db"
        ).build()
    }
}