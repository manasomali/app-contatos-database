package com.example.exerciciodatabase.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exerciciodatabase.Contato
import com.example.exerciciodatabase.Repository
import kotlinx.coroutines.launch

class ListaContatosViewModel(val repository: Repository): ViewModel() {
    var listaContato = MutableLiveData<List<Contato>>()

    fun getAllContatoDB() {
        viewModelScope.launch {
            listaContato.value = repository.getAllContatoTask()
        }
    }

    fun clearContatoDB(){
        viewModelScope.launch {
            repository.deleteAllContatoTask()
        }
    }
}