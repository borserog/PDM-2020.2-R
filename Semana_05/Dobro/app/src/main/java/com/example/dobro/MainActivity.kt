package com.example.dobro

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btFechar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btFechar = findViewById(R.id.btFechar)

        var valor = 0

        if (intent.hasExtra("VALOR")){
            valor = intent.getIntExtra("VALOR", 0)
        }

        this.btFechar.setOnClickListener({
            val intent = Intent()
            intent.putExtra("DOBRO", valor * 2)
            setResult(Activity.RESULT_OK, intent)
            finish()
        })
    }

}