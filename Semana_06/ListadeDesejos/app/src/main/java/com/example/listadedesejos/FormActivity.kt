package com.example.listadedesejos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class FormActivity : AppCompatActivity() {
    private lateinit var etDescricao: EditText
    private lateinit var etValor: EditText
    private lateinit var btAdd: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etDescricao = findViewById(R.id.etFormDescricao)
        this.etValor = findViewById(R.id.etFormValor)
        this.btAdd = findViewById(R.id.btFormAdd)
        this.btCancelar = findViewById(R.id.btFormCancelar)

        if (intent.hasExtra("DESEJO")){
            val desejo = intent.getSerializableExtra("DESEJO") as Desejo
            this.etDescricao.setText(desejo.descricao)
            this.etValor.setText(desejo.valor.toString())
            this.btAdd.text = "Atualizar"
        }

        this.btAdd.setOnClickListener({ add(it) })
        this.btCancelar.setOnClickListener({ cancelar(it) })
    }

    private fun add(view: View){
        val descricao = this.etDescricao.text.toString()
        val valor = this.etValor.text.toString().toFloat()

        val desejo = if (intent.hasExtra("DESEJO")){
            val d = intent.getSerializableExtra("DESEJO") as Desejo
            d.descricao = descricao
            d.valor = valor
            d
        }else{
            Desejo(descricao, valor)
        }

        val intent = Intent()
        intent.putExtra("DESEJO", desejo)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun cancelar(view: View){
        finish()
    }
}