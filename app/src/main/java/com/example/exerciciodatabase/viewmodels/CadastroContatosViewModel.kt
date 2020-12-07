package com.example.exerciciodatabase.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exerciciodatabase.Contato
import com.example.exerciciodatabase.Repository
import kotlinx.coroutines.launch

class CadastroContatosViewModel(val repository: Repository): ViewModel() {
    var listaContato = MutableLiveData<List<Contato>>()

    fun addContatoDB(gasto: Contato){
        viewModelScope.launch {
            listaContato.value = repository.addContatoTask(gasto)
        }
    }
}