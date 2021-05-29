package com.example.bancodedados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private lateinit var dao: PessoaDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.dao = PessoaDAO(this)

        //this.inserir()
        //this.atualizar()
        //this.remover()
        this.procurar()
    }

    // primeira, segunda

    private fun inserir(){
        val p = Pessoa("Segunda", 20)
        this.dao.insert(p)
        Log.i("BANCO_LOG", this.dao.select().toString())
    }

    private fun atualizar(){
        val p = Pessoa(1, "Primeira", 100)
        this.dao.update(p)
        Log.i("BANCO_LOG", this.dao.select().toString())
    }

    private fun remover(){
        this.dao.delete(1)
        Log.i("BANCO_LOG", this.dao.select().toString())
    }

    private fun procurar(){
        Log.i("BANCO_LOG", this.dao.find(2).toString())
        Log.i("BANCO_LOG", this.dao.find(1).toString())
        Log.i("BANCO_LOG", this.dao.select().toString())
    }

}