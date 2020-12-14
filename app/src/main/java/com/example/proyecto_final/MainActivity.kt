package com.example.proyecto_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun  LanzarBitacora(view: View) {
        val intent = Intent(this,Bitacora_de_registro::class.java)
        startActivity(intent)
    }
    fun  LanzarUbicarme(view: View) {
        val intent = Intent(this,MapsActivity ::class.java)
        startActivity(intent)
    }

}