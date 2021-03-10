package com.example.aplicativos

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btHtml: Button
    private lateinit var btDobro: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btHtml = findViewById(R.id.btHtml)
        this.btHtml.setOnClickListener({ html(it) })

        this.btDobro = findViewById(R.id.btDobro)
        this.btDobro.setOnClickListener({ dobro(it) })
    }

    private fun html(view: View){
        //val uri = Uri.parse("http://www.ifpb.edu.br")
        val uri = Uri.parse("http://wa.me/+558398763792")
        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }else{
            Toast.makeText(this, "Erro, não tem activity", Toast.LENGTH_SHORT).show()
        }
    }

    private fun dobro(view: View){
        val intent = Intent("DOBRO_DO_NUMERO")
        intent.putExtra("VALOR", 10)
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == 1){
                val dobro = data?.getIntExtra("DOBRO", 0)
                Toast.makeText(this, dobro.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}