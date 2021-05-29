package com.example.telas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class OutraActivity : AppCompatActivity() {
    private lateinit var btVolta: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outra)

        Log.i("APP_TELAS", "Outra: onCreate")

        val msg = intent.getStringExtra("MSG_IDA")
        Log.i("APP_TELAS", "Enviada: " + msg.toString())

        this.btVolta = findViewById(R.id.btOutraVolta)
        this.btVolta.setOnClickListener({ clickBotao(it) })
    }

    fun clickBotao(view: View){
        val intent = Intent()
        intent.putExtra("MSG_VOLTA", "Funciona mesmo!")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.i("APP_TELAS", "Outra: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("APP_TELAS", "Outra: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("APP_TELAS", "Outra: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("APP_TELAS", "Outra: onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("APP_TELAS", "Outra: onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("APP_TELAS", "Outra: onDestroy")
    }
}