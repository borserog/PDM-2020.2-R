package com.example.idade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var etNome: EditText
    private lateinit var etIdade: EditText
    private lateinit var btCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.etNome = findViewById(R.id.etMainNome)
        this.etIdade = findViewById(R.id.etMainIdade)
        this.btCalcular = findViewById(R.id.btMainCalcular)

        this.btCalcular.setOnClickListener({ calcular(it) })
    }

    private fun calcular(view: View){
        val nome = this.etNome.text.toString()
        val idade = this.etIdade.text.toString().toInt()

        val pessoa = Pessoa(nome, idade)

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("PESSOA", pessoa)
        startActivity(intent)
    }
}