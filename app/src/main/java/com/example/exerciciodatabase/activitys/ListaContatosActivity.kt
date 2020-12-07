package com.example.exerciciodatabase.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exerciciodatabase.*
import com.example.exerciciodatabase.adapters.ListaContatoAdapter
import com.example.exerciciodatabase.database.BaseDadosContatos
import com.example.exerciciodatabase.viewmodels.CadastroContatosViewModel
import com.example.exerciciodatabase.viewmodels.ListaContatosViewModel
import kotlinx.android.synthetic.main.activity_lista_contatos.*

class ListaContatosActivity : AppCompatActivity(), ListaContatoAdapter.OnClickListener {

    lateinit var repository: Repository
    lateinit var db: BaseDadosContatos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_contatos)

        db = BaseDadosContatos.invoke(this)
        repository = RepositoryImplementation(db.contatoDAO())
        val viewModel by viewModels<ListaContatosViewModel> {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return ListaContatosViewModel(repository) as T
                }
            }
        }

        viewModel.getAllContatoDB()
        viewModel.listaContato.observe(this) {
            recyclerview_contatos.adapter =
                ListaContatoAdapter(
                    it,
                    this
                )
        }
        recyclerview_contatos.layoutManager = LinearLayoutManager(this)
        recyclerview_contatos.setHasFixedSize(true)

        floatingactionbutton_adiconacontato.setOnClickListener {
            var intent = Intent(this, CadastroContatosActivity::class.java)
            startActivity(intent)
        }
        floatingactionbutton_cleardb.setOnClickListener {
            viewModel.clearContatoDB()
            var intent = Intent(this, ListaContatosActivity::class.java)
            startActivity(intent)
        }
    }

    override fun itemClick(position: Int) {
        println(position)
    }
}