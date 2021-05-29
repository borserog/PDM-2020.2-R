package com.example.broadcast

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var receiver: TelaReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.receiver = TelaReceiver()
    }

    override fun onResume() {
        super.onResume()
        val itf = IntentFilter()
        itf.addAction(Intent.ACTION_USER_PRESENT)
        registerReceiver(this.receiver, itf)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(this.receiver)
    }
}