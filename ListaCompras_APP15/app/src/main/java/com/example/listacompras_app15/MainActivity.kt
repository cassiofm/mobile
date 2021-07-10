package com.example.listacompras_app15

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity(), ItemAdapterListener {

    lateinit var itemAdapter: ItemAdapter
    lateinit var edtItem: EditText
    lateinit var btnIncluir: ImageButton
    lateinit var preferenciasItem: SharedPreferences
    lateinit var rv: RecyclerView

    var db: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // #Preferencias
        // Criando o arquivo de preferências
        preferenciasItem = getSharedPreferences("itemPreferences", MODE_PRIVATE)

        rv = findViewById<RecyclerView>(R.id.rvItems)

        btnIncluir = findViewById(R.id.btnIncluir)
        edtItem = findViewById(R.id.edtItem)

        btnIncluir.setOnClickListener() {
            if (edtItem.text.toString().isNotEmpty()) {
                adicionarItem(edtItem.text.toString())
                edtItem.text.clear()

                // Apagar a preferência gravada anteriormente
                val editor = preferenciasItem.edit()
                editor.remove("NOME")
                editor.commit()
            } else {
                edtItem.error = "Insira um texto válido!"
            }
        }
    }

    fun adicionarItem(nomeItem: String) {
        // Coroutine para Entrada/Saída de Dados
        CoroutineScope(Dispatchers.IO).launch {
            // Cria ou recupera o BD da aplicação
            db = DatabaseBuilder.getAppDatabase(this@MainActivity)

            // A partir do DAO executa uma ação escolhida (INSERT)
            db?.itemDao()?.addItems(Item(nome = nomeItem))

            // Recupera ações/métodos de acesso a dados da entidade (tabela)
            val itemDAO = db?.itemDao()

            // A partir do DAO executa uma ação escolhida (SELECT)
            val resposta = itemDAO?.getItems()

            // Coroutine para UI
            withContext(Dispatchers.Main) {
                resposta?.let {
                    itemAdapter.refreshListItem(resposta)
                }
            }
        }
    }

    fun recuperarLista(){
        // Coroutine para Entrada/Saída de Dados
        CoroutineScope(Dispatchers.IO).launch {
            // Cria ou recupera o BD da aplicação
            db = DatabaseBuilder.getAppDatabase(this@MainActivity)

            // Recupera ações/métodos de acesso a dados da entidade (tabela)
            val itemDAO = db?.itemDao()

            // A partir do DAO executa uma ação escolhida (SELECT)
            val resposta = itemDAO?.getItems()

            // Coroutine para UI
            withContext(Dispatchers.Main){
                resposta?.let{
                    itemAdapter = ItemAdapter(it, this@MainActivity)

                    // Vincula o Adapter na Recycler View
                    rv.adapter = itemAdapter

                    // Exibe os itens em uma coluna única no padrão vertical
                    rv.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        }
    }

    // #Preferencias
    override fun onPause() {
        super.onPause()

        if (edtItem.text.toString().isNotEmpty()){

            // Cria e edição na preferência
            val editor = preferenciasItem.edit()

            // Escreve um uma preferência
            editor.putString("NOME", edtItem.text.toString())

            // Salva a preferência
            editor.commit()
        }
    }

    // #Preferencias
    override fun onResume() {
        super.onResume()

        // Recupera (lê) uma preferência e utiliza ela populando um Edit Text
        edtItem.setText(preferenciasItem.getString("NOME", null))
    }

    override fun onStart() {
        super.onStart()

        recuperarLista()
    }

    override fun excluirItem(item: Item) {
        // Coroutine para Entrada/Saída de Dados
        CoroutineScope(Dispatchers.IO).launch {
            // Cria ou recupera o BD da aplicação
            db = DatabaseBuilder.getAppDatabase(this@MainActivity)

            // A partir do DAO executa uma ação escolhida (DELETE)
            db?.itemDao()?.deleteItem(item)

            // Recupera ações/métodos de acesso a dados da entidade (tabela)
            val itemDAO = db?.itemDao()

            // A partir do DAO executa uma ação escolhida (SELECT)
            val resposta = itemDAO?.getItems()

            // Coroutine para UI
            withContext(Dispatchers.Main) {
                resposta?.let {
                    itemAdapter.refreshListItem(resposta)

                    Toast.makeText(this@MainActivity, "Item excluída", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}