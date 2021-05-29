package com.example.listadedesejos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

const val ADD = 1
const val EDIT = 2
class MainActivity : AppCompatActivity() {
    private lateinit var lvDesejos: ListView
    private lateinit var fabAdd: FloatingActionButton
    private lateinit var lista: ArrayList<Desejo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lista = ArrayList()

        this.lvDesejos = findViewById(R.id.lvMainDesejos)
        this.fabAdd = findViewById(R.id.fabMainAdd)

        this.lvDesejos.adapter = ArrayAdapter<Desejo>(this, android.R.layout.simple_list_item_1, this.lista)

        this.lvDesejos.setOnItemClickListener(ClickLista())
        this.lvDesejos.setOnItemLongClickListener(ClickLongLista())

        this.fabAdd.setOnClickListener({ add(it) })
    }

    private fun add(view: View){
        val intent = Intent(this, FormActivity::class.java)
        startActivityForResult(intent, ADD)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == ADD){
                val desejo = data?.getSerializableExtra("DESEJO") as Desejo
                (this.lvDesejos.adapter as ArrayAdapter<Desejo>).add(desejo)
                Log.i("APP_DESEJOS", this.lista.toString())
            }else if (requestCode == EDIT){
                val desejo = data?.getSerializableExtra("DESEJO") as Desejo
                for (d in this.lista){
                    if (d.id == desejo.id){
                        d.descricao = desejo.descricao
                        d.valor = desejo.valor
                        (this.lvDesejos.adapter as ArrayAdapter<Desejo>).notifyDataSetChanged()
                        break
                    }
                }
            }
        }
    }

    inner class ClickLista: AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val desejo = this@MainActivity.lista[position]
            val intent = Intent(this@MainActivity, FormActivity::class.java)
            intent.putExtra("DESEJO", desejo)
            startActivityForResult(intent, EDIT)
        }
    }

    inner class ClickLongLista: AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long
        ): Boolean {
            val desejo = this@MainActivity.lista[position]
            (this@MainActivity.lvDesejos.adapter as ArrayAdapter<Desejo>).remove(desejo)
            return true
        }
    }
}