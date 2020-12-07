package com.example.exerciciodatabase.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.exerciciodatabase.Contato
import com.example.exerciciodatabase.R

class ListaContatoAdapter(private val listContato: List<Contato>, val listener: OnClickListener): RecyclerView.Adapter<ListaContatoAdapter.ListaContatoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaContatoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contato_item, parent, false)
        return ListaContatoViewHolder(itemView)
    }

    override fun getItemCount() = listContato.size

    override fun onBindViewHolder(holder: ListaContatoViewHolder, position: Int) {
        var item = listContato[position]
        holder.nome.text = item.nome
        holder.telefone.text = item.telefone
        holder.email.text = item.email

    }
    inner class ListaContatoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val nome: TextView = itemView.findViewById(R.id.item_nome)
        val telefone: TextView = itemView.findViewById(R.id.item_telefone)
        val email: TextView = itemView.findViewById(R.id.item_email)

        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            if (RecyclerView.NO_POSITION != position) {
                listener.itemClick(position)
            }
        }
    }
    interface OnClickListener {
        fun itemClick(position: Int)
    }
    fun updateList() {
        this.notifyDataSetChanged()
    }

}