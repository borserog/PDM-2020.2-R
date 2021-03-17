package com.example.lista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var etNome: EditText
    private lateinit var btAdd: Button
    private lateinit var lvNomes: ListView
    private lateinit var lista: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lista = ArrayList()

        this.etNome = findViewById(R.id.etNome)
        this.btAdd = findViewById(R.id.btAdd)
        this.lvNomes = findViewById(R.id.lvNomes)

        val layout = android.R.layout.simple_list_item_1
        this.lvNomes.adapter = ArrayAdapter<String>(this, layout ,this.lista)

        this.lvNomes.setOnItemClickListener(ClickNoItemDaLista())
        this.lvNomes.setOnItemLongClickListener(ClickLongoNoItemDaLista())

        this.btAdd.setOnClickListener({ addNome(it) })
    }

    private fun addNome(view: View){
        val nome = this.etNome.text.toString()
        this.lista.add(nome)
        (this.lvNomes.adapter as ArrayAdapter<String>).notifyDataSetChanged()
        //(this.lvNomes.adapter as ArrayAdapter<String>).add(nome)
        this.etNome.text.clear()
    }

    inner class ClickNoItemDaLista: AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val nome = this@MainActivity.lista[position]
            Toast.makeText(this@MainActivity, nome, Toast.LENGTH_SHORT).show()
        }
    }

    inner class ClickLongoNoItemDaLista: AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
            val nome = this@MainActivity.lista[position]
            (this@MainActivity.lvNomes.adapter as ArrayAdapter<String>).remove(nome)
            return true
        }
    }
}