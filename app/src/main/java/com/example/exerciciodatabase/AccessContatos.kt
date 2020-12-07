package com.example.exerciciodatabase

import androidx.room.*

@Dao
interface AccessContatos {

    @Query("SELECT * FROM contatos")
    suspend fun getAllContato(): List<Contato>

    @Insert
    suspend fun addContato(contato: Contato)

    @Query("DELETE FROM contatos")
    suspend fun delAllContato()

    @Update
    suspend fun updateContato(contato: Contato)
}