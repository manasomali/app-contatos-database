package com.example.exerciciodatabase.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.exerciciodatabase.viewmodels.CadastroContatosViewModel
import com.example.exerciciodatabase.Contato
import com.example.exerciciodatabase.R
import com.example.exerciciodatabase.Repository
import com.example.exerciciodatabase.RepositoryImplementation
import com.example.exerciciodatabase.database.BaseDadosContatos
import com.example.exerciciodatabase.viewmodels.ListaContatosViewModel
import kotlinx.android.synthetic.main.activity_cadastro_contatos.*

class CadastroContatosActivity : AppCompatActivity() {

    lateinit var db: BaseDadosContatos
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_contatos)
        imageview_cadastrotolista.setColorFilter(R.color.azulpetroleo)
        imageview_cadastrotolista.setOnClickListener {
            var intent = Intent(this, ListaContatosActivity::class.java)
            startActivity(intent)
        }

        db = BaseDadosContatos.invoke(this)
        repository = RepositoryImplementation(db.contatoDAO())
        val viewModel by viewModels<CadastroContatosViewModel> {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return CadastroContatosViewModel(repository) as T
                }
            }
        }
        button_adicionar.setOnClickListener {
            viewModel.addContatoDB(Contato(nome = edittext_nome.text.toString(), email = edittext_email.text.toString(), telefone = edittext_telefone.text.toString()))
            var intent = Intent(this, ListaContatosActivity::class.java)
            startActivity(intent)
        }
    }
}