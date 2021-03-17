package com.example.foto

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import com.google.android.material.floatingactionbutton.FloatingActionButton

const val CAMERA = 1
class MainActivity : AppCompatActivity() {
    private lateinit var ivFoto: ImageView
    private lateinit var fabAdd: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.ivFoto = findViewById(R.id.ivFoto)
        this.fabAdd = findViewById(R.id.fabAdd)

        this.fabAdd.setOnClickListener(ClickBotao())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == CAMERA){
                val foto = data?.getParcelableExtra<Bitmap>("data")
                this.ivFoto.setImageBitmap(foto)
            }
        }
    }

    inner class ClickBotao: View.OnClickListener{
        override fun onClick(v: View?) {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, CAMERA)
            }
        }
    }
}