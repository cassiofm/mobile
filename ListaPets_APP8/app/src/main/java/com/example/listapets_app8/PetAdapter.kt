package com.example.listapets_app8


import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PetAdapter(var listaPets: MutableList<Pet>):RecyclerView.Adapter<PetAdapter.ItemViewHolder>() {

    // Responsável por encontrar os componentes dentro do layout (item_usuario) e indicar que o
    //  layout será replicado na Recycler View
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgFoto: ImageView = view.findViewById(R.id.imgFoto)
        val txtNome: TextView = view.findViewById(R.id.txtNome)
        val txtDono: TextView = view.findViewById(R.id.txtDono)
        val txtTipo: TextView = view.findViewById(R.id.txtTipo)
    }

    // Responsável por inflar (fazer aparecer) o layout por exemplo na activity ou fragment ou dialog (tudo que extends View Group)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pet, parent, false)
        return ItemViewHolder(view)
    }

    // Vincula os componentes do layout (item_usuario) a um dado/propriedade/atributo da lista
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        listaPets[position].foto?.let {
            holder.imgFoto.setImageDrawable(it)
        }
        holder.txtNome.text = listaPets[position].nome
        holder.txtDono.text = listaPets[position].dono
        holder.txtTipo.text = listaPets[position].tipo
    }

    // Indica quantos registros/itens a lista possui
    override fun getItemCount(): Int {
        return listaPets.size
    }
}