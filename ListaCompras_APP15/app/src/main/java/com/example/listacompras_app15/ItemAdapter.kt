package com.example.listacompras_app15

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import java.net.URI

class ItemAdapter(var listaItem: List<Item>, var listener: ItemAdapterListener):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // Responsável por encontrar os componentes dentro do layout (item_usuario) e indicar que o
    //  layout será replicado na Recycler View
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtItem: TextView = view.findViewById(R.id.txtItem)
        val btnExcluir: ImageButton = view.findViewById(R.id.btnExcluir)
    }

    // Responsável por inflar (fazer aparecer) o layout por exemplo na activity ou fragment ou dialog (tudo que extends View Group)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_compra, parent, false)
        return ItemViewHolder(view)
    }

    // Vincula os componentes do layout (item_usuario) a um dado/propriedade/atributo da lista
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.txtItem.text = listaItem[position].nome

        // Implementando o "click" do CardView para retornar um Toast como mensagem
        holder.btnExcluir.setOnClickListener(){
            listener.excluirItem(listaItem[position])
        }
    }

    // Indica quantos registros/itens a lista possui
    override fun getItemCount(): Int {
        return listaItem.size
    }

    fun refreshListItem(listaAtualizada: List<Item>){
        listaItem= listaAtualizada
        notifyDataSetChanged()
    }
}
