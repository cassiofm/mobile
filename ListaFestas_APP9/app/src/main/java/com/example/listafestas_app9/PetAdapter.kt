package com.example.listafestas_app9


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FestaAdapter(var listaFestas: MutableList<Festa>):RecyclerView.Adapter<FestaAdapter.ItemViewHolder>() {

    // Responsável por encontrar os componentes dentro do layout (item_usuario) e indicar que o
    //  layout será replicado na Recycler View
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgFoto: ImageView = view.findViewById(R.id.imgFoto)
        val txtNome: TextView = view.findViewById(R.id.txtNome)
        val txtDono: TextView = view.findViewById(R.id.txtDono)
        val txtTema: TextView = view.findViewById(R.id.txtTema)
    }

    // Responsável por inflar (fazer aparecer) o layout por exemplo na activity ou fragment ou dialog (tudo que extends View Group)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_festa, parent, false)
        return ItemViewHolder(view)
    }

    // Vincula os componentes do layout (item_usuario) a um dado/propriedade/atributo da lista
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        listaFestas[position].foto?.let {
            holder.imgFoto.setImageDrawable(it)
        }
        holder.txtNome.text = listaFestas[position].nome
        holder.txtDono.text = listaFestas[position].dono
        holder.txtTema.text = listaFestas[position].tema
    }

    // Indica quantos registros/itens a lista possui
    override fun getItemCount(): Int {
        return listaFestas.size
    }
}