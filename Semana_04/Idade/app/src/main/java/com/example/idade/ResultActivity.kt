package com.example.idade

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    private lateinit var tvMsg: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        this.tvMsg = findViewById(R.id.tvResultMsg)
        this.tvMsg.setOnClickListener({ click(it) })

        if (intent.hasExtra("PESSOA")){
            val pessoa = intent.getSerializableExtra("PESSOA") as Pessoa
            this.tvMsg.text = "${pessoa.nome}, você possui ${pessoa.idade()} anos."
        }else{
            this.tvMsg.text = "Eita! Deu erro!"
        }
    }

    private fun click(view: View){
        finish()
    }
}