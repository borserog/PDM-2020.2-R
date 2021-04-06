package com.example.bancodedados

import android.content.ContentValues
import android.content.Context

class PessoaDAO {
    private lateinit var banco: BancoHelper

    constructor(context: Context){
        this.banco = BancoHelper(context)
    }

    fun insert(pessoa: Pessoa){
        val cv = ContentValues()
        cv.put("nome", pessoa.nome)
        cv.put("idade", pessoa.idade)
        this.banco.writableDatabase.insert("pessoas", null, cv)
    }

    fun select(): ArrayList<Pessoa>{
        val lista = ArrayList<Pessoa>()
        val colunas = arrayOf("id", "nome", "idade")

        val cursor = this.banco.readableDatabase.query("pessoas", colunas, null, null, null, null, "nome")
        cursor.moveToFirst()

        for (i in 1..cursor.count){
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val nome = cursor.getString(cursor.getColumnIndex("nome"))
            val idade = cursor.getInt(cursor.getColumnIndex("idade"))
            lista.add(Pessoa(id, nome, idade))
            cursor.moveToNext()
        }

        return lista
    }

    fun count(): Int{
        val sql = "select count(id) from pessoas"
        val cursor = this.banco.readableDatabase.rawQuery(sql, null)
        cursor.moveToFirst()
        return cursor.getInt(0)
    }

    fun find(id: Int): Pessoa?{
        val colunas = arrayOf("id", "nome", "idade")
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())

        val cursor = this.banco.readableDatabase.query("pessoas", colunas, where, pWhere, null, null, null)
        cursor.moveToFirst()

        if (cursor.count == 1){
            val id = cursor.getInt(cursor.getColumnIndex("id"))
            val nome = cursor.getString(cursor.getColumnIndex("nome"))
            val idade = cursor.getInt(cursor.getColumnIndex("idade"))
            return Pessoa(id, nome, idade)
        }

        return null
    }

    fun update(pessoa: Pessoa){
        val where = "id = ?"
        val pWhere = arrayOf(pessoa.id.toString())
        val cv = ContentValues()
        cv.put("nome", pessoa.nome)
        cv.put("idade", pessoa.idade)
        this.banco.writableDatabase.update("pessoas", cv, where, pWhere)
    }

    fun delete(id: Int){
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        this.banco.writableDatabase.delete("pessoas", where, pWhere)
    }
}