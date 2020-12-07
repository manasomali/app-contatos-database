package com.example.exerciciodatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName="contatos")
data class Contato(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var nome: String,
    var email: String,
    var telefone: String
)